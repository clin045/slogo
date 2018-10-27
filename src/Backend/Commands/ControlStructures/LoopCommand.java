package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public abstract class LoopCommand extends Command {
    public LoopCommand(VariableTracker tracker){super(tracker);};
    protected int start,end,increment;
    protected String key;
    protected final String END_DELIMETER="]";
    protected final String START_DELIMETER="[";


    @Override
    public String execute(List<String> params) {
        List<String>tempList=new ArrayList<>();
        double out=0;

        for(int i=start;i<=end;i+=increment){
            super.myTracker.put(key,(double)i);
            tempList=new ArrayList<>(params);
            if(!tempList.get(0).equals(START_DELIMETER)){throw new IllegalArgumentException("Loop commands must be surrounded by square brackets");}
            tempList.remove(START_DELIMETER);
            while(tempList.size()>0){
                if(tempList.get(0).equals(END_DELIMETER)){
                    tempList.remove(0);
                    break;}
                Command loopCmd= CommandManager.getCommand(tempList.get(0), myTracker);
                tempList.remove(0);
                out=Double.parseDouble(loopCmd.execute(tempList));
            }
        }
        params.clear();
        for(String s:tempList){params.add(s);}
        return ""+out;
    }
}
