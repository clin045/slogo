//package Backend.Commands;
//
//import Backend.VariableTracker;
//
//public class CommandHideTurtle extends TurtleCommands{
//    public CommandHideTurtle(VariableTracker tracker){
//        super(tracker);
//    }
//
//    @Override
//    public int getParamNumber() {
//        return 0;
//    }
//
//    @Override
//    public String getDescription() {
//        return "HIDETURTLE: makes turtle invisible";
//    }
//
//    @Override
//    public void parseParameters(String[] params) throws IllegalArgumentException {
//        if(params.length==0){
//            return;
//        }else{throw new IllegalArgumentException("Wrong number of parameters. Expect: "+getParamNumber()+" got: "+params.length);}
//    }
//
//    @Override
//    public String execute() {
//        myTracker.getTurtle().hide();
//        return "0";
//    }
//}
