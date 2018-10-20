package Backend.Commands;

import Backend.VariableTracker;

public class CommandLeft extends TurtleCommands{
    private double leftAmt;
    public CommandLeft(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public int getParamNumber() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "LEFT: Turns the turtle left by some number of degrees";
    }

    @Override
    public void parseParameters(String[] params) throws IllegalArgumentException {
        if(params.length==1){
            try{leftAmt=Double.parseDouble(params[0]);
            }catch (Exception e){throw new IllegalArgumentException("LEFT needs a double parameter");}
        }else{throw new IllegalArgumentException("Wrong number of parameters. Expect: "+getParamNumber()+" got: "+params.length);}
    }

    @Override
    public String execute() {
        var turtle = myTracker.getTurtle();

        return Double.toString(turtle.left(leftAmt));
    }
}
