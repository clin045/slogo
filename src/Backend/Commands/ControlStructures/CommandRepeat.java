package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

public class CommandRepeat extends LoopCommand {
   private static final String mykey="Repeat";
    public CommandRepeat(VariableTracker tracker){super(tracker);
    setKey(mykey);
    }


    @Override
    public String execute(List<String> params) {
        start=1;
        try{
            end=(int)parseParameter(params);
        }
        catch(Exception e){
            throw new InvalidSyntaxException(key);
        }
        increment =1;
        key = "repCount";
        if(!params.get(0).equals("[")||params.indexOf("]")==-1){throw new IllegalArgumentException("Commands inside repeat block need to be surrounded by brackets");}
           return super.execute(params);
    }
}
