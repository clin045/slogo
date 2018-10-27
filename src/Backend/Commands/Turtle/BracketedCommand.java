package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public abstract class BracketedCommand extends Command {
    BracketedCommand(VariableTracker tracker){
        super(tracker);
    }
    @Override
    public abstract String getDescription();

    @Override
    public abstract String execute(List<String> params);

    protected ArrayList<Double> evaluateBrackets(List<String> exp) {
        exp.remove("[");
        exp.remove("]");
        //check if each param is a command, if so, evaluate it
        var retList = new ArrayList<Double>();
        while(exp.size() > 0){
            if(CommandManager.isCommand(exp.get(0))){
                var cmd = CommandManager.getCommand(exp.get(0), myTracker);
                exp.remove(0);
                try{
                    var doubVal = Double.parseDouble(cmd.execute(exp.subList(0, exp.size())));
                    retList.add(doubVal);

                }
                catch(Exception e){
                    throw new IllegalArgumentException("Invalid params for Tell");
                }
            }
            else{
                try{
                    retList.add(Double.parseDouble(exp.get(0)));
                    exp.remove(0);
                }
                catch(Exception e){
                    throw new IllegalArgumentException("Invalid params for Tell");
                }
            }
        }
        return retList;
    }

}
