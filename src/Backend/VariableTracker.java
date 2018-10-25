/**
 * @author Max Bartlett
 */

package Backend;


import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.*;

public class VariableTracker {
    private Turtle turtle;
    private ObservableMap<String, Object> varMap;
    private ObservableMap<String, List<String>>commandMap;

    private Map<Integer, Turtle> turtleMap;
    private int activeTurtle;

    /**
     * Default constructor initializes Turtle() and HashMap()
     */
    public VariableTracker(){
        turtle = new Turtle();
        varMap = FXCollections.observableMap(new HashMap<>());
        commandMap=FXCollections.observableMap(new HashMap<>());
        turtleMap = new HashMap<>();

        activeTurtle = 0;
        createTurtle(0);
    }

    public void createTurtle(int id){
        turtleMap.put(id, new Turtle(id));
    }

    /**
     * Returns active turtle, creates a new one if it does not exist
     * @return turtle
     */
    public Turtle getActiveTurtle() {
        if(turtleMap.containsKey(activeTurtle)){
            return turtleMap.get(activeTurtle);
        }
        else{
            createTurtle(activeTurtle);
            return turtleMap.get(activeTurtle);
        }
    }

    public void setActiveTurtle(int id){
        activeTurtle = id;
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
//        for(String str:commandSequence){System.out.print(str+" ");}
//        System.out.println(" ");
    }
    public List<String> getCommand(String key){
        return commandMap.get(key);
    }
    public void clearCommands(){
        commandMap.clear();
    }
    public String executeCommand(String key){
//        System.out.println("done");
        return "done";
    }

    public ObservableMap<String, List<String>> getCommandMap() {
        return commandMap;
    }

    public ObservableMap<String, Object> getVarMap() {
        return varMap;
    }
}
