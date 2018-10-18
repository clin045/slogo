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

    private Map<String, Command>myCommands;
    private TextParser myParser;
    private VariableTracker myTracker;

    /**
     * default constructor
     */
    public CommandManager(){
        myParser=new TextParser();
        myCommands=new HashMap<>();
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
        myTracker = new VariableTracker();
       myParser=new TextParser(path);
        myCommands=new HashMap<>();

        setCommands();
        for(String key:myCommands.keySet()){
            System.out.println(myCommands.get(key).getDescription()+" Params:"+myCommands.get(key).getParamNumber());
        }
    }



    public String execute(String userInput){
        Stack<String>[]parsedInput=myParser.parse(userInput, myCommands);
        Stack<String>commands=parsedInput[0];
        Stack <String>params = parsedInput[1];
       while(!commands.empty()){
           String currentStr=commands.pop();
           Command current=myCommands.get(currentStr);
           String [] args= new String[current.getParamNumber()];
           for(int i=0;i<current.getParamNumber();i+=1){
               args[i]=params.pop();
           }
          current.parseParameters(args);
           if(current.returnValueAsParam()){
               String out=current.execute();
               System.out.println(out);
               params.push(out);
           }else{System.out.println(current.execute());}
       }


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
