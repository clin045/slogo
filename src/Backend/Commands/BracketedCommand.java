package Backend.Commands;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public abstract class BracketedCommand extends Command {
    protected final String END_DELIMETER = "]";
    protected final String START_DELIMETER = "[";

    public BracketedCommand(VariableTracker tracker) {
        super(tracker);
    }

    @Override
    public abstract String execute(List<String> params);

    protected int getCloseIndex(List<String> str) {
        int startIndex = str.indexOf(START_DELIMETER);
        if (startIndex <= -1 || str.indexOf(END_DELIMETER) < startIndex) {
            throw new IllegalArgumentException("Need [");
        }
        int numOpen = 1;
        int numClosed = 0;
        for (int index = startIndex + 1; index < str.size(); index += 1) {
            if (str.get(index).equals(START_DELIMETER)) {
                numOpen += 1;
            }
            if (str.get(index).equals(END_DELIMETER)) {
                numClosed += 1;
            }
            if (numOpen == numClosed) {
                return index;
            }
        }
        throw new IllegalArgumentException("Brackets don't match");
    }

    protected ArrayList<Double> evaluateBrackets(List<String> exp) {
//        exp.remove(getCloseIndex(exp));
//        exp.remove(START_DELIMETER);
        //check if each param is a command, if so, evaluate it
        var retList = new ArrayList<Double>();
        while (exp.size() > 0) {
            if (CommandManager.isCommand(exp.get(0), myTracker)) {
                var cmd = CommandManager.getCommand(exp, myTracker);
                exp.remove(0);
                try {
                    var doubVal = Double.parseDouble(cmd.execute(exp));
                    retList.add(doubVal);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new IllegalArgumentException("Invalid params for bracketed expression");
                }
            } else {
                try {
                    retList.add(Double.parseDouble(exp.get(0)));
                    exp.remove(0);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Invalid params for bracketed expression");
                }
            }
        }
        return retList;
    }
}
