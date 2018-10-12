package Model;

import java.util.*;

/**
 * 
 */
public interface Command {

    /**
     * @param methodKey
     */
    public Object execute(List<String>params);
    
    /**
     * @return numberOfParameters
     */
    public int getParamNumber();

}