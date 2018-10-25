package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public class CommandFor extends Command {
    private String varName;
    public CommandFor(VariableTracker tracker){
        super(tracker);
    }
    @Override
    public String getDescription() {
        return "runs command(s) for each value specified in the range, i.e., from (start - end), going by increment";
    }

    @Override
    public String execute(List<String> params) {
        List<String>tempList;
        double out=0;
        if(!params.remove(0).equals("[")){throw new IllegalArgumentException("Limit must be enclosed by brackets []");}//[ v s e i ]
        if(!params.remove(4).equals("]")){throw new IllegalArgumentException("FOR only takes 3 limit argument");}//0 1 2 3 4 5
        varName=params.remove(0);
        int start=(int)parseParameters(params);
        int end=(int)parseParameters(params);
        int increment=(int)parseParameters(params);
        for(int i=start;i<=end;i+=increment){
            super.myTracker.put(varName,(double)i);
            tempList=new ArrayList<>(params);
            if(!tempList.get(0).equals("[")){throw new IllegalArgumentException("FOR commands must be surrounded by square brackets");}
            tempList.remove("[");
            while(tempList.size()>0){
                if(tempList.get(0).equals("]")){break;}
                if(tempList.get(0).equals("[")){break;}

                Command loopCmd= CommandManager.getCommand(tempList.get(0), );
                tempList.remove(0);
                out=Double.parseDouble(loopCmd.execute(tempList));
            }
        }
        return ""+out;
    }
}
