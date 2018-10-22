/**
 * @author Max Bartlett
 */

package Backend;

import java.util.*;

public class VariableTracker {
    private Turtle turtle;
    private Map<String, Object> varMap;
    private Map<String, List<String>>commandMap;

    /**
     * Default constructor initializes Turtle() and HashMap()
     */
    public VariableTracker(){
        turtle = new Turtle();
        varMap = new HashMap<>();
        commandMap=new HashMap<>();
    }

    /**
     * @return turtle
     */
    public Turtle getTurtle() {
        return turtle;
    }

    /**
     * puts <Key, Value> in varMap
     * @param key variable name
     * @param value variable value
     * @return value if key already exists in varMap, otherwise null
     */
    public Object put(String key, Object value) {
        return varMap.put(key, value);
    }

    /**
     * gets value associated with key from varMap
     * @param key key to be accessed
     * @return value if key exists in varMap, otherwise null
     */
    public Object get(String key) {
        return varMap.get(key);
    }

    /**
     * removes key from varMap
     * @param key key to be removed
     * @return previous value if key exists in varMap, otherwise null
     */
    public Object remove(String key) {
        return varMap.remove(key);
    }

    /**
     * @return set containing all var names
     */
    public Set<String> keySet() {
        return varMap.keySet();
    }

    /**
     * clears varMap
     */
    public void clear() {
        varMap.clear();
    }

    public void putCommand(String key, List<String>commandSequence){
        commandMap.put(key,commandSequence);
        for(String str:commandSequence){System.out.print(str+" ");}
        System.out.println(" ");
    }
    public List<String> getCommand(String key){
        return commandMap.get(key);
    }
    public void clearCommands(){
        commandMap.clear();
    }
    public String executeCommand(String key){
        System.out.println("done");
        return "done";
    }

}
