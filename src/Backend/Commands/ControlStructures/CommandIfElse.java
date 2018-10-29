package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.Commands.BracketedCommand;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandIfElse extends BracketedCommand {
    private static final String key = "Ifelse";
    public CommandIfElse(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }


    @Override
    public String execute(List<String> params) {
        int openBracket = params.indexOf("[");

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
            openBracket = params.indexOf("[");
            int closeBracket = params.indexOf("]");
            if(openBracket == -1 || closeBracket == -1 || closeBracket < openBracket){
                throw new InvalidSyntaxException(key);
            }
            try{
                for(int i = 0; i <= closeBracket+1;i++){
                    params.remove(0);
                }
            }
            catch(Exception e){
                throw new InvalidSyntaxException(key);
            }
            List<Double> retVals = evaluateBrackets(params);


            return Double.toString(retVals.get(0));
        }
        else{
            int closeBracket = params.indexOf("]");
            //var commandParams = params.subList(1, closeBracket);
            for(int i = closeBracket+1; i < params.size(); i++){
                params.remove(i);
            }
            List<Double> retVals = evaluateBrackets(params);


            return Double.toString(retVals.get(0));
        }
    }


}
