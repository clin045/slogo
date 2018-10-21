//package Backend.Commands;
//
//import Backend.VariableTracker;
//
//public class CommandTowards extends TurtleCommands{
//    int pointX;
//    int pointY;
//
//    public CommandTowards(VariableTracker tracker){
//        super(tracker);
//    }
//
//    @Override
//    public int getParamNumber() {
//        return 2;
//    }
//
//    @Override
//    public String getDescription() {
//        return "TOWARDS: Sets heading towards a point";
//    }
//
//    @Override
//    public void parseParameters(String[] params) throws IllegalArgumentException {
//        if(params.length==2){
//            try{
//                pointX =Integer.parseInt(params[0]);
//                pointY = Integer.parseInt(params[1]);
//            }catch (Exception e){throw new IllegalArgumentException("TOWARDS takes 2 ints pointX and pointY");}
//        }else{throw new IllegalArgumentException("Wrong number of parameters. Expect: "+getParamNumber()+" got: "+params.length);}
//    }
//
//    @Override
//    //TODO: Check graphically that this works properly
//    public String execute() {
//        var myTurtle = myTracker.getTurtle();
//        return Double.toString(myTurtle.towards(pointX,pointY));
//    }
//}
