package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandIf extends Command {
    private static final String key = "If";
    public CommandIf(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        System.out.println("enter");
        int openBracket = params.indexOf("[");
        int closeBracket = params.indexOf("]");
        if(openBracket == -1 || closeBracket == -1 || closeBracket < openBracket){
            throw new InvalidSyntaxException(key);
        }
        var expressionParams = params.subList(0, openBracket);
        var firstExpressionString = expressionParams.get(0);
        Command firstExpressionCommand = null;
        double expressionValue = -1;
        System.out.println(firstExpressionString);
        if(CommandManager.isCommand(firstExpressionString)){
            firstExpressionCommand = CommandManager.getCommand(firstExpressionString, myTracker);
        }
        else{
            //indicates that first expression is a value, not a command
            expressionValue = Double.parseDouble(firstExpressionString);
        }
        expressionParams.remove(0);
        if(expressionValue == -1){
            expressionValue = Double.parseDouble(firstExpressionCommand.execute(expressionParams));
        }

        if(expressionValue == 0){
            return "0";
        }
        else{
            params.remove("[");
            var firstCommandStr = params.get(0);
            Command firstCommand = CommandManager.getCommand(firstCommandStr, myTracker);
            params.remove(0);
            String str=firstCommand.execute(params);

            params.remove("]");
            return str;
        }

    }
}
