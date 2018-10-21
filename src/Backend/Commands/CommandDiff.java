//package Backend.Commands;
//
//import Backend.VariableTracker;
//
///**
// * @author Michael Glushakov mg367
// */
//public class CommandDiff extends MathCommand {
//    private double d1,d2;
//
//    public CommandDiff(VariableTracker tracker){
//        super(tracker);
//
//    }
//    @Override
//    public String getDescription() {
//        return "DIFFERENCE: returns difference of the arguments";
//    }
//
//    @Override
//    public void parseParameters(String[] params) throws IllegalArgumentException {
//        try{
//            d1=Double.parseDouble(params[1]);
//            d2=Double.parseDouble(params[0]);
//        }catch (Exception e){
//            throw new IllegalArgumentException("Could not parse input "+params[0]+","+params[1]);
//        }
//    }
//
//    @Override
//    public String execute() {
//        return ""+(d1-d2);
//    }
//}
