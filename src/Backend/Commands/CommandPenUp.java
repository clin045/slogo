package Backend.Commands;

import Backend.VariableTracker;

public class CommandPenUp extends TurtleCommands {

    CommandPenUp(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public int getParamNumber() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "PENUP: puts pen up such that when the turtle moves, it does not leave a trail";
    }

    @Override
    public void parseParameters(String[] params) throws IllegalArgumentException {
        if(params.length==0){
           return;
        }else{throw new IllegalArgumentException("Wrong number of parameters. Expect: "+getParamNumber()+" got: "+params.length);}
    }

    @Override
    public String execute() {
        myTracker.getTurtle().penUp();
        return "0";
    }
}
