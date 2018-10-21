package Backend.Commands;

import Backend.VariableTracker;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class CommandFD extends TurtleCommands {
    private double amountFD;
    private final int PARAM_NUMBER=1;
    public CommandFD(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public int getParamNumber() {
        return PARAM_NUMBER;
    }
    @Override
    public String getDescription(){
        return "FORWARD: Moves Turtle forward by a set amount of pixels";
    }

//    @Override
//    public void parseParameters(String[]params) throws IllegalArgumentException {
//        if(params.length==1){
//            try{amountFD=Integer.parseInt(params[0]);
//            }catch (Exception e){throw new IllegalArgumentException("Forward needs an integer parameter");}
//        }else{throw new IllegalArgumentException("Wrong number of parameters. Expect: "+getParamNumber()+" got: "+params.length);}
//    }


    public String execute(List<String> params) {
        System.out.println("Executing");
        var turtle = myTracker.getTurtle();
        amountFD=parseParameters(params);
        turtle.forward(amountFD);
        //String[] remains= Arrays.copyOfRange(params,)
        return Double.toString(amountFD);
    }



}
