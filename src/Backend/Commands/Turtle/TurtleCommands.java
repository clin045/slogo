package Backend.Commands.Turtle;

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

    public abstract int getParamNumber();

    @Override
    public abstract String getDescription();





}
