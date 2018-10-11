package Model;

import java.util.*;

/**
 * 
 */
public interface VariableTracker {

    /**
     * @param  key
     * @param  value
     */
    public void addVar( String key,  Object value);

    /**
     * @param  key
     */
    public void getVariable( String key);

    /**
     * 
     */
    public void getAllVariables();

    /**
     * 
     */
    public void clearAllVariables();

    /**
     * @param  key
     */
    public void deleteVar( String key);

    /**
     * @param  key
     * @param  value
     */
    public void setVar( String key,  Object value);

}