package Backend.Commands;

import Backend.Command;
import Backend.VariableTracker;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**@author Christopher Lin cl349
 *
 */
public abstract class TurtleCommands extends Command {


    TurtleCommands(){
        super();
    }

    @Override
    public int getParamNumber() {
        return 1;
    }

    @Override
    public abstract String getDescription();





}
