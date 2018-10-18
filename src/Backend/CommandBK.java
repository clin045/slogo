package Backend;

/**
 * @author Christopher Lin cl349
 */

public class CommandBK implements  Command {
    private int amountBack;
    private VariableTracker myTracker;

    CommandBK(VariableTracker tracker){
        myTracker = tracker;
    }

    @Override
    public int getParamNumber() {
        return 1;
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

    @Override
    public boolean hasReturnValue() {
        return false;
    }
}
