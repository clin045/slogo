package Backend.Commands;

import Backend.Command;
import Backend.TextParser;
import Backend.VariableTracker;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.ResourceBundle;

/**
 * @author Michael Glushakov (mg367)
 */
public class CommandManager {

    private static final Map<String, Command>myCommands= new HashMap<>();
    private static final String WHITESPACE =" ";
    private TextParser myParser;
    private static final VariableTracker myTracker=new VariableTracker();

    /**
     * default constructor
     */
    public CommandManager(){
        myParser=new TextParser();

        setCommands();
        for(String key:myCommands.keySet()){
            System.out.println(myCommands.get(key).getDescription()+" Params:"+myCommands.get(key).getParamNumber());
        }
    };

    /**
     * Constructor with a predefined language
     * @param path path to the resource bundle containing the language specific commands
     */
    public CommandManager(String path){

       myParser=new TextParser(path);


        setCommands();
        for(String key:myCommands.keySet()){
            System.out.println(myCommands.get(key).getDescription()+" Params:"+myCommands.get(key).getParamNumber());
        }
    }

    public static Command getCommand(String str){
        ResourceBundle commandBundle = ResourceBundle.getBundle("config.Commands");
        try{
            Class commandStr= Class.forName(commandBundle.getString(str));
            Command command= (Command) commandStr.getDeclaredConstructor(VariableTracker.class).newInstance(myTracker);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return myCommands.get(str);
    }



    public String execute(String userInput){
        String out="";
       // Integer counter=0;
        List<String>parsedList = myParser.parse(userInput,myCommands);
        while(parsedList.size()>0){
            Command init=myCommands.get(parsedList.get(0));
            if(init==null){throw new IllegalArgumentException("Invalid input");}
            parsedList.remove(0);
            out+=init.execute(parsedList);
            System.out.println(parsedList.size());
        }

        return out;
    }
    private String executeControlStructure(String userInput){
        //Command controlStructure=
        return "";
    }

//_________________________________________MIDDLEWARE___________________________________________________________________


    /**
     * @author Michael Glushakov (mg367)
     * @apiNote Followed Java 10 Class Documentation and this link: http://www.avajava.com/tutorials/lessons/how-do-i-instantiate-an-object-of-a-class-via-its-string-name.html?page=2
     * @apiNote To Implement new Commands: add the matching key-value pair to the config/Commands resource bundle; Backend.Command class must have a constructor that accepts a VariableTracker
     */
    private void setCommands(){
      try{
        ResourceBundle commandBundle = ResourceBundle.getBundle("config.Commands");
          for(String key: Collections.list(commandBundle.getKeys())){
              try{
                  Class commandStr= Class.forName(commandBundle.getString(key));
                  Command command= (Command) commandStr.getDeclaredConstructor(VariableTracker.class).newInstance(myTracker);
                  myCommands.put(key,command);
              } catch (ClassNotFoundException e) {
                  e.printStackTrace();
                  throw new RuntimeException("Could Not Load Backend.Command String: "+e.getMessage());
              } catch (IllegalAccessException e) {
                  e.printStackTrace();
                  throw new RuntimeException("Could Not Create Backend.Command Object: "+e.getMessage());
              } catch (InstantiationException e) {
                  e.printStackTrace();
                  throw new RuntimeException("Could Not Create Backend.Command Object: "+e.getMessage());
              } catch (NoSuchMethodException e) {
                  e.printStackTrace();
                  throw new RuntimeException("Could not Create Backend.Command Object");
              } catch (InvocationTargetException e) {
                  e.printStackTrace();
              }

          }
      }catch (MissingResourceException e){
          e.printStackTrace();
      }

    }
}
