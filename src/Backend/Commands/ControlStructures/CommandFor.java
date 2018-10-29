package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public class CommandFor extends LoopCommand{
    private static final String myKey="For";
    public CommandFor(VariableTracker tracker){
        super(tracker);
        setKey(myKey);
    }

    @Override
    public String execute(List<String> params) {
        if(!params.remove(0).equals(START_DELIMETER)){throw new InvalidSyntaxException(myKey);}//[ v s e i ]
        if(!params.remove(4).equals(END_DELIMETER)){throw new InvalidSyntaxException(myKey);}//0 1 2 3 4 5
        key =params.remove(0);
        try{
            start=(int) parseParameter(params);
            end=(int) parseParameter(params);
            increment=(int) parseParameter(params);
        }
        catch(Exception e){
            throw new InvalidSyntaxException(myKey);
        }

        return super.execute(params);
    }
}
