package Backend.Commands;

import Backend.VariableTracker;

public class CommandRight extends TurtleCommands{
    private double rightAmt;
    CommandRight(VariableTracker tracker){
        super(tracker);
    }
    @Override
    public String getDescription() {
        return "RIGHT: Turns the turtle right by some number of degrees";
    }

    @Override
    public void parseParameters(String[] params) throws IllegalArgumentException {
        if(params.length==1){
            try{
                rightAmt =Double.parseDouble(params[0]);
            }catch (Exception e){throw new IllegalArgumentException("RIGHT needs a double parameter");}
        }else{throw new IllegalArgumentException("Wrong number of parameters. Expect: "+getParamNumber()+" got: "+params.length);}
    }

    @Override
    public String execute() {
        var turtle = myTracker.getTurtle();
        double newOrientation = turtle.getOrientation() + rightAmt;
        turtle.setOrientation(newOrientation);
        return "Executed RIGHT " + rightAmt;
    }
}
