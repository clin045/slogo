package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public class CommandDoTimes extends Command {
    private int limit;
    private String varName;
    public CommandDoTimes(VariableTracker tracker){super(tracker);}
    @Override
    public String getDescription() {
        return "runs command(s) for each value specified in the range, i.e., from (1 - limit) inclusive";
    }

    @Override
    public String execute(List<String> params) {
        List<String>tempList;
        if(!params.remove(0).equals("[")){throw new IllegalArgumentException("Limit must be enclosed by brackets []");}
        if(!params.remove(2).equals("]")){throw new IllegalArgumentException("DOTIMES only takes one limit argument");}
        varName=params.remove(0);
        limit=(int)parseParameters(params);
//        System.out.println("DOTIMES limit: "+limit);
//        System.out.println("param size: "+params.size());
        double temp=1;
        double out=0;
        while((int)temp<=limit){
            super.myTracker.put(varName,(double)temp);
            tempList=new ArrayList<>(params);
            if(!tempList.get(0).equals("[")){throw new IllegalArgumentException("DOTIMES commands must be surrounded by square brackets");}
            tempList.remove("[");
            while(tempList.size()>0){
                if(tempList.get(0).equals("]")){break;}
                if(tempList.get(0).equals("[")){break;}
                Command loopCmd= CommandManager.getCommand(tempList.get(0));
                tempList.remove(0);
                out=Double.parseDouble(loopCmd.execute(tempList));
                temp+=1;
            }
        }
        return ""+temp;
    }
}
