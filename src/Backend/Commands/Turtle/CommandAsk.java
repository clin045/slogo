package Backend.Commands.Turtle;

import Backend.Command;
import Backend.Turtle;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public class CommandAsk extends BracketedCommand {

    public CommandAsk(VariableTracker tracker){
        super(tracker);
    }
                      @Override
    public String getDescription() {
        return "only the turtles given in first list all run commands given in the second list";
    }

    @Override
    public String execute(List<String> params) {
        int openBracket = params.indexOf("[");
        int closeBracket = params.indexOf("]");
        if(openBracket == -1 || closeBracket == -1 || closeBracket < openBracket){
            throw new IllegalArgumentException("Invalid brackets");
        }
        var turtleExp = params.subList(openBracket+1, closeBracket);
        var turtleIdDoubles = evaluateBrackets(turtleExp);
        var turtleIDs = new ArrayList<Integer>();

        for (Double d : turtleIdDoubles){
            turtleIDs.add(d.intValue());
        }

        var oldTurtleList = new ArrayList<Turtle>();
        oldTurtleList.addAll(myTracker.getTurtleManager().getActiveTurtles());

        myTracker.getTurtleManager().setActiveTurtlesByID(turtleIDs);
        List<String> commandExp = new ArrayList<>();
        try{
            commandExp = params.subList(closeBracket+1, params.size()-1);
            commandExp.remove("[");
            commandExp.remove("]");
        }
        catch(Exception e){
            throw new IllegalArgumentException("Command list invalid in ASK");
        }
        var retList = evaluateBrackets(commandExp);

        myTracker.getTurtleManager().setActiveTurtles(oldTurtleList);

        return Double.toString(retList.get(retList.size()-1));
    }
}
