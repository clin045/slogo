package Backend.Commands;

import Backend.Command;
import Backend.VariableTracker;

/**@author Christopher Lin cl349
 *
 */
public abstract class TurtleCommands implements Command {
    public VariableTracker myTracker;

    public TurtleCommands(VariableTracker tracker){
        myTracker = tracker;
    }

    public abstract int getParamNumber();

    @Override
    public abstract String getDescription();

    @Override
    public abstract void  parseParameters(String[] params) throws IllegalArgumentException;
    @Override
    public abstract String execute();

    @Override
    public boolean returnValueAsParam() {
        return false;
    }
}
