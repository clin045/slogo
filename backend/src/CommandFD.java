public class CommandFD implements Command {
    private int amountFD;
    private final int PARAM_NUMBER=1;
    public CommandFD(){}

    @Override
    public int getParamNumber() {
        return PARAM_NUMBER;
    }
    @Override
    public String getDescription(){
        return "FORWARD: Moves Turtle forward by a set amount of pixels";
    }

    @Override
    public void parseParameters(String[]params) throws IllegalArgumentException {
        if(params.length==1){
            try{amountFD=Integer.parseInt(params[0]);
            }catch (Exception e){throw new IllegalArgumentException("Forward needs an integer parameter");}
        }else{throw new IllegalArgumentException("Wrong number of parameters. Expect: "+getParamNumber()+" got: "+params.length);}
    }

    @Override
    public String execute() {
        String out= "Executed FD "+amountFD;
        amountFD=0;
        return out;
    }

    @Override
    public boolean hasReturnValue() {
        return false;
    }

}
