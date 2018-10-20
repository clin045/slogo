package Backend.Commands;

import Backend.VariableTracker;

public class CommandSetXY extends TurtleCommands {
    int pointX;
    int pointY;
    CommandSetXY(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public int getParamNumber() {
        return 2;
    }

    @Override
    public String getDescription() {
        return "SETXY: moves turtle to an absolute screen position, where (0, 0) is the center of the screen\n" +
                "returns the distance turtle moved";
    }

    @Override
    public void parseParameters(String[] params) throws IllegalArgumentException {
        if(params.length==2){
            try{
                pointX =Integer.parseInt(params[0]);
                pointY = Integer.parseInt(params[1]);
            }catch (Exception e){throw new IllegalArgumentException("SETXY takes 2 ints pointX and pointY");}
        }else{throw new IllegalArgumentException("Wrong number of parameters. Expect: "+getParamNumber()+" got: "+params.length);}
    }

    @Override
    public String execute() {
        var myTurtle = myTracker.getTurtle();
        return Double.toString(myTurtle.setXY(pointX,pointY));

    }
}
