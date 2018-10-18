package Backend.Commands;

import Backend.Command;
import Backend.VariableTracker;

/**@author Christopher Lin cl349
 *
 */
public abstract class TurtleCommands implements Command {
    protected VariableTracker myTracker;

    TurtleCommands(VariableTracker tracker){
        myTracker = tracker;
    }

    @Override
    public int getParamNumber() {
        return 1;
    }

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
