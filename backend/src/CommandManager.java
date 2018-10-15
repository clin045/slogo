import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
import java.util.regex.Pattern;
import java.util.ResourceBundle;

/**
 * @author Michael Glushakov (mg367)
 */
public class CommandManager {
    private List<Entry<String, Pattern>>mySymbols;
    private Map<String, Command>myCommands;

    /**
     * default constructor
     */
    public CommandManager(){
        mySymbols=new ArrayList<>();
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
        mySymbols=new ArrayList<>();
        myCommands=new HashMap<>();
        setLanguage(path);
        setCommands();
        for(String key:myCommands.keySet()){
            System.out.println(myCommands.get(key).getDescription()+" Params:"+myCommands.get(key).getParamNumber());
        }
    }

    /**
     * @author Robert C. Duvall
     * @apiNote sets the language o be recognized by the parser
     * @param path: url path to the properties file location
     */
    public void setLanguage(String path){
        mySymbols.clear();
        ResourceBundle languageBundle=ResourceBundle.getBundle(path);
        for(var key: Collections.list(languageBundle.getKeys())){
            var regex = languageBundle.getString(key);
            mySymbols.add(new SimpleEntry<>(key,Pattern.compile(regex,Pattern.CASE_INSENSITIVE)));
        }
    }

    /**
     * @author Robert C. Duvall
     * @author Michael Glushakov (mg367)
     * @param text
     * @return the String matcing the key in the Command Map
     * @throws IllegalArgumentException
     */
    private String getSymbol(String text)throws IllegalArgumentException{
        final String ERROR= "INVALID EXPRESSION: ";
        for(var e:mySymbols){
            if(e.getValue().matcher(text).matches()){
                return e.getKey();
            }
        }
        throw new IllegalArgumentException(ERROR+text);
    }

    /**
     * @author Michael Glushakov (mg367)
     * @apiNote Followed Java 10 Class Documentation and this link: http://www.avajava.com/tutorials/lessons/how-do-i-instantiate-an-object-of-a-class-via-its-string-name.html?page=2
     * @apiNote To Implement new Commands: add the matching key-value pair to the config/Commands resource bundle; Command class must have a constructor with no parameters
     */
    private void setCommands(){
      try{
        ResourceBundle commandBundle = ResourceBundle.getBundle("resources/config/Commands");
          for(String key: Collections.list(commandBundle.getKeys())){
              try{
                  Class commandStr= Class.forName(commandBundle.getString(key));
                  Command command= (Command) commandStr.getDeclaredConstructor().newInstance();
                  myCommands.put(key,command);
              } catch (ClassNotFoundException e) {
                  e.printStackTrace();
                  throw new RuntimeException("Could Not Load Command String: "+e.getMessage());
              } catch (IllegalAccessException e) {
                  e.printStackTrace();
                  throw new RuntimeException("Could Not Create Command Object: "+e.getMessage());
              } catch (InstantiationException e) {
                  e.printStackTrace();
                  throw new RuntimeException("Could Not Create Command Object: "+e.getMessage());
              } catch (NoSuchMethodException e) {
                  e.printStackTrace();
                  throw new RuntimeException("Could not Create Command Object");
              } catch (InvocationTargetException e) {
                  e.printStackTrace();
              }

          }
      }catch (MissingResourceException e){
          e.printStackTrace();
      }

    }
}
