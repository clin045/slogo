package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.Commands.BracketedCommand;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandIf extends BracketedCommand {
    private static final String key = "If";
    public CommandIf(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {

        for(String s:params){System.out.print(s+" ");}

        int openBracket = params.indexOf(START_DELIMETER);
        var expressionParams = params.subList(0, openBracket);
        var firstExpressionString = expressionParams.get(0);

        Command firstExpressionCommand = null;
        double expressionValue = -1;
        if(CommandManager.isCommand(firstExpressionString, myTracker)){
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
            return "0";
        }
        else{
            openBracket = params.indexOf("[");
            System.out.println("OPENBRACKET: "+openBracket);
            int closeBracket = getCloseIndex(params);
            //Probably needs to be taken out
            if(openBracket == -1 || closeBracket == -1 || closeBracket < openBracket){
                throw new InvalidSyntaxException(key);
            }
            //-------------------------------------------

           List<String> bracketExp = params.subList(openBracket+1, closeBracket);
            List<Double> returnVals = evaluateBrackets(bracketExp);
            params.remove(getCloseIndex(params));
            params.remove(params.indexOf(START_DELIMETER));
            return Double.toString(returnVals.get(0));
        }

    }
}
