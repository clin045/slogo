//package Backend.Commands;
//
//import Backend.Command;
//import Backend.VariableTracker;
//
//public class CommandMult extends MathCommand {
//    private double d1,d2;
//    public CommandMult(VariableTracker tracker){super(tracker);}
//
//    @Override
//    public String getDescription() {
//        return "PRODUCT: returns product of the arguments";
//    }
//
//    @Override
//    public void parseParameters(String[] params) throws IllegalArgumentException {
//        try{
//            d1=Double.parseDouble(params[0]);
//            d2=Double.parseDouble(params[1]);
//        }catch (Exception e){
//            throw new IllegalArgumentException("Could not parse input "+params[0]+","+params[1]);
//        }
//    }
//
//    @Override
//    public String execute() {
//        return ""+(d1*d2);
//    }
//}
