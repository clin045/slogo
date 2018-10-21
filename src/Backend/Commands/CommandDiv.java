//package Backend.Commands;
//
//import Backend.VariableTracker;
//
//public class CommandDiv extends MathCommand {
//    private double d1,d2;
//    public CommandDiv(VariableTracker tracker){super(tracker);}
//    @Override
//    public String getDescription() {
//        return "QUOTIENT: returns quotient of the parameters";
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
//        if(d2==0){throw new IllegalArgumentException("CANNOT DIVIDE BY 0");}
//    }
//
//    @Override
//    public String execute() {
//        return ""+(d1/d2);
//    }
//}
