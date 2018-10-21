//package Backend.Commands;
//
//import Backend.Command;
//import Backend.VariableTracker;
//
//public abstract class TurtleQueries implements Command {
//    protected VariableTracker myTracker;
//    @Override
//    public int getParamNumber() {
//        return 0;
//    }
//
//    public TurtleQueries(VariableTracker tracker){
//        myTracker = tracker;
//    }
//
//
//    public abstract String getDescription();
//
//
//    @Override
//    public void parseParameters(String[] params) throws IllegalArgumentException {
//        if(params.length==0){
//            return;
//        }else{throw new IllegalArgumentException("Wrong number of parameters. Expect: "+getParamNumber()+" got: "+params.length);}
//
//    }
//
//
//    public abstract String execute();
//    @Override
//    public boolean returnValueAsParam() {
//        return false;
//    }
//}
