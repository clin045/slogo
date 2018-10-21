package Backend.Commands;

import Backend.Turtle;
import Backend.VariableTracker;

public class CommandSetHeading extends TurtleCommands {
    private double heading;
    public CommandSetHeading(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public int getParamNumber() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "SETHEADING: Sets the turtle's heading";
    }

    @Override
    public void parseParameters(String[] params) throws IllegalArgumentException {
        if(params.length==1){
            try{heading=Double.parseDouble(params[0]);
            }catch (Exception e){throw new IllegalArgumentException("LEFT needs a double parameter");}
        }else{throw new IllegalArgumentException("Wrong number of parameters. Expect: "+getParamNumber()+" got: "+params.length);}

    }

    @Override
    public String execute() {
        Turtle myTurtle = myTracker.getTurtle();
        double amtMoved = Math.abs(myTurtle.getHeading()-heading);
        myTurtle.setHeading(heading);
        return Double.toString(amtMoved);
    }
}