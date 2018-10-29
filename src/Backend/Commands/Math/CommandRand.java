package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;


public class CommandRand extends Command {
    private int upperBound;
    private static final String key="Random";
    public CommandRand(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        try {
            upperBound = (int) parseParameter(params);
        }
        catch(Exception e) {
            throw new InvalidSyntaxException(key);
        }

        if(upperBound <= 0) {
            throw new IllegalArgumentException("Random ceiling must be positive");
        }
        int random = (int) (Math.random() * upperBound;
        return Integer.toString(random);
    }
}
