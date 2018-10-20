package Backend.Commands;

import Backend.VariableTracker;

public class CommandPenDown extends TurtleCommands{

    CommandPenDown(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public int getParamNumber() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "PENDOWN: puts pen down such that when the turtle moves, it leaves a trail";
    }

    @Override
    public void parseParameters(String[] params) throws IllegalArgumentException {
        if(params.length==0){
            return;
        }else{throw new IllegalArgumentException("Wrong number of parameters. Expect: "+getParamNumber()+" got: "+params.length);}
    }

    @Override
    public String execute() {
        myTracker.getTurtle().penDown();
        return "0";
    }
}
