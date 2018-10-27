package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public class CommandFor extends Command {
    private String varName;
    private final String END_DELIMETER="]";
    private final String START_DELIMETER="[";
    public CommandFor(VariableTracker tracker){
        super(tracker);
    }
    @Override
    public String getDescription() {
        return "runs command(s) for each value specified in the range, i.e., from (start - end), going by increment";
    }

    @Override
    public String execute(List<String> params) {
        List<String>tempList=new ArrayList<>();
        double out=0;
        if(!params.remove(0).equals(START_DELIMETER)){throw new IllegalArgumentException("Limit must be enclosed by brackets []");}//[ v s e i ]
        if(!params.remove(4).equals(END_DELIMETER)){throw new IllegalArgumentException("FOR only takes 3 limit argument");}//0 1 2 3 4 5
        varName=params.remove(0);
        int start=(int) parseParameter(params);
        int end=(int) parseParameter(params);
        int increment=(int) parseParameter(params);
        for(int i=start;i<=end;i+=increment){
            super.myTracker.put(varName,(double)i);
            tempList=new ArrayList<>(params);
            if(!tempList.get(0).equals(START_DELIMETER)){throw new IllegalArgumentException("FOR commands must be surrounded by square brackets");}
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
