package Backend;

/**
 * @author Christopher Lin cl349
 */

public class CommandBK extends TurtleCommands{
    private int amountBack;
    public static final int NUM_PARAMS = 1;
    CommandBK(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public int getParamNumber() {
        return NUM_PARAMS;
    }

    @Override
    public String getDescription() {
        return "BACK: Moves Turtle backward by a set amount of pixels";
    }

    @Override
    public void parseParameters(String[] params) throws IllegalArgumentException {
        if(params.length==1){
            try{amountBack=Integer.parseInt(params[0]);
            }catch (Exception e){throw new IllegalArgumentException("Forward needs an integer parameter");}
        }else{throw new IllegalArgumentException("Wrong number of parameters. Expect: "+getParamNumber()+" got: "+params.length);}
    }

    @Override
    public String execute() {
        var turtle = myTracker.getTurtle();
        turtle.move(amountBack *-1);
        String out= "Executed BK "+amountBack;
        amountBack=0;
        return out;
    }

}
