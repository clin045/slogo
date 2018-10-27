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
        if (userInput.length()==0){return "";}
        String out="";
        List<String> masterList = myParser.parse(userInput);
        while(masterList.size()>0){
            System.out.println("exexuting with:");
            for(String s:masterList){System.out.println(s);}
            if(masterList.get(0).equals("[")){return out;}
            if(isCommand(masterList.get(0))){
                Command init=getCommand(masterList.get(0), myTracker);
                masterList.remove(0);
                out=init.execute(masterList);
            }
            else {
                if(masterList.get(0).charAt(0)==':'){
                    Double val=(Double) myTracker.get(masterList.get(0).substring(1));
                    if(val==null){
                        List<String>userCommand=myTracker.getCommand(masterList.get(0).substring(1));
                        String commandName=masterList.get(0);
                        if(userCommand!=null){
                            masterList.addAll(0,userCommand);
                            masterList.remove(commandName);
                        }
                        else{throw new InvalidInputException(masterList.get(0));}}
                    else{
                        out=""+val;
                        masterList.remove(0);
                    }
                }
                else{
                    throw new InvalidVariableCallException();
                }
            }
        }
       // System.out.println(out);

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
                    myCommands.put(key,getCommand(key,myTracker));
            }
        }catch (MissingResourceException e){
            throw new CommandParsingException("");
        }

    }
    public VariableTracker getMyTracker(){return myTracker;}

}
