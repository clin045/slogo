package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public class CommandRepeat extends Command {
    private String[] input;
    private int repeatNumber;
    public CommandRepeat(VariableTracker tracker){super(tracker);}

    @Override
    public String getDescription() {
        return "runs command(s) given in the list the value of expr number of times\n" +
                "returns the value of the final command executed (or 0 if no commands are executed)\n" +
                "note, the value of the current iteration, starting at 1, is automatically assigned to the variable :repcount so that it can be accessed by the command(s)";
    }

    @Override
    public String execute(List<String> params) {
//        System.out.println(params.size());
        repeatNumber=(int) parseParameter(params);
//        System.out.println("Repeat num: "+repeatNumber);
//        System.out.println("param size: "+params.size());
//        System.out.println(params.get(0));
        if(!params.get(0).equals("[")||params.indexOf("]")==-1){throw new IllegalArgumentException("Commands inside repeat block need to be surrounded by brackets");}


//        String out="";
        double d1=0;
        List<String>temp=new ArrayList<>();
        for (int i=1;i<=repeatNumber;i+=1){
            super.myTracker.put("repcount",(double)i);
//            System.out.println("LOOP: "+i+"/"+repeatNumber);
           // System.out.println("REPCOUNT: "+CommandManager.myTracker.get("repcount"));
            temp=new ArrayList<>(params);
            temp.remove("[");
            while(temp.size()>0){
                if(temp.get(0).equals("]")){break;}
                if(temp.get(0).equals("[")){break;}
//                System.out.println("Temp: ");
                //for(String str:temp){System.out.println(str);}
                Command loopCmd= CommandManager.getCommand(temp.get(0), myTracker);
//                System.out.println("got commands");
                temp.remove(0);
                String loop=loopCmd.execute(temp);
//                System.out.println("executed: "+loop);
//                out+="|"+loop;
                d1=Double.parseDouble(loop);
            }

        }


        return ""+d1;
    }
}
