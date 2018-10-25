package Backend;


import Backend.Exceptions.CommandParsingException;
import Backend.Exceptions.InvalidInputException;
import Backend.Exceptions.InvalidVariableCallException;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.ResourceBundle;

/**
 * @author Michael Glushakov (mg367)
 */
public class CommandManager {
    public static final String ERROR_PATH="config.Errors";
    public static final String COMMAND_PATH="config.Commands";

    public static Map<String, Command> getCommands() {
        return myCommands;
    }

    private static final Map<String, Command>myCommands= new HashMap<>();
    private TextParser myParser;
    private VariableTracker myTracker;




    /**
     * default constructor
     */
    public CommandManager(){
        myParser=new TextParser();
        preloadCommands();

    };

    /**
     * Constructor with a predefined language
     * @param path path to the resource bundle containing the language specific commands
     */
    public CommandManager(String path){

       myParser=new TextParser(path);
       myTracker=new VariableTracker();
       preloadCommands();

    }

    public static Command getCommand(String str, VariableTracker tracker){
        ResourceBundle commandBundle = ResourceBundle.getBundle(COMMAND_PATH);
        try{
            Class commandStr= Class.forName(commandBundle.getString(str));
            Command command= (Command) commandStr.getDeclaredConstructor(VariableTracker.class).newInstance(tracker);
            return command;
        } catch (ClassNotFoundException e) {
            throw new CommandParsingException(str);
        } catch (IllegalAccessException e) {
            throw new CommandParsingException(str);
        } catch (InstantiationException e) {
            throw new CommandParsingException(str);
        } catch (NoSuchMethodException e) {
            throw new CommandParsingException(str);
        } catch (InvocationTargetException e) {
            throw new CommandParsingException(str);
        }
    }

    public void setLanguage(String path){
        myParser.setLanguage(path);
    }
    public static boolean isCommand(String cmd){
        return myCommands.containsKey(cmd);
    }

    public String execute(String userInput){
        String out="";
        List<String>parsedList = myParser.parse(userInput);
        while(parsedList.size()>0){
            if(parsedList.get(0).equals("[")){return out;}
            try{  Command init=getCommand(parsedList.get(0), myTracker);
                if(init==null){throw new InvalidInputException();}

                parsedList.remove(0);
                out=init.execute(parsedList);
            }catch (MissingResourceException e){
                if(parsedList.get(0).charAt(0)==':'){
                    Double val=(Double) myTracker.get(parsedList.get(0).substring(1));
                    if(val==null){
                        List<String>userCommand=myTracker.getCommand(parsedList.get(0).substring(1));
                        String commandName=parsedList.get(0);
                        if(userCommand!=null){
                            parsedList.addAll(0,userCommand);

                            parsedList.remove(commandName);
                        }
                        else{throw new InvalidInputException(parsedList.get(0));}}
                    else{
                    out=""+val;
                    parsedList.remove(0);
                    }
                }
                else{
                    throw new InvalidVariableCallException();
                }

            }

        }

        return out;
    }
    public Map<String, Object> getUserVariables(){
        return myTracker.getVarMap();
    }
    public Map<String, List<String>> getUserCommands(){
        return myTracker.getCommandMap();
    }

    private void preloadCommands(){
        try{
            ResourceBundle commandBundle = ResourceBundle.getBundle(COMMAND_PATH);
            for(String key: Collections.list(commandBundle.getKeys())){
                try{
                    Class commandStr= Class.forName(commandBundle.getString(key));
                    Command command= (Command) commandStr.getDeclaredConstructor(VariableTracker.class).newInstance(myTracker);
                    myCommands.put(key,command);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    throw new CommandParsingException(key);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    throw new CommandParsingException(key);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                    throw new CommandParsingException(key);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    throw new CommandParsingException(key);
                } catch (InvocationTargetException e) {
                    throw new CommandParsingException(key);
                }

            }
        }catch (MissingResourceException e){
            throw new CommandParsingException("");
        }

    }
    public VariableTracker getMyTracker(){return myTracker;}

}
