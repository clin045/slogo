package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandIfElse extends Command {
    private static final String key = "Ifelse";
    public CommandIfElse(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }


    @Override
    public String execute(List<String> params) {
        int openBracket = params.indexOf("[");
        int closeBracket = params.indexOf("]");
        if(openBracket == -1 || closeBracket == -1 || closeBracket < openBracket){
            throw new InvalidSyntaxException(key);
        }
        var expressionParams = params.subList(0, openBracket);
        var firstExpressionString = expressionParams.get(0);
        Command firstExpressionCommand = null;
        double expressionValue = -1;
        if(CommandManager.isCommand(firstExpressionString)){
            firstExpressionCommand = CommandManager.getCommand(expressionParams, myTracker);
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
            closeBracket = params.indexOf("]");
            for(int i = 0; i <= closeBracket;i++){
                params.remove(0);
            }

            params.remove("[");
            var firstCommandStr = params.get(0);
            Command firstCommand = CommandManager.getCommand(expressionParams, myTracker);
            params.remove(0);
            String str=firstCommand.execute(params);

            params.remove("]");
            return str;
        }
        else{

            //var commandParams = params.subList(1, closeBracket);
            params.remove("[");
            var firstCommandStr = params.get(0);
            Command firstCommand = CommandManager.getCommand(expressionParams, myTracker);
            params.remove(0);
            String str=firstCommand.execute(params);
            closeBracket = params.indexOf("]");
            for(int i = closeBracket; i < params.size(); i++){
                params.remove(i);
            }
            return str;
        }
    }


}
