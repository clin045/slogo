/**
 * @author Max Bartlett
 */

package Backend;

import FrontEnd.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VariableTracker {
    private Turtle turtle;
    private Map<String, Object> varMap;

    /**
     * Default constructor initializes Turtle() and HashMap()
     */
    public VariableTracker(){
        turtle = new Turtle();
        varMap = new HashMap<>();
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



}
