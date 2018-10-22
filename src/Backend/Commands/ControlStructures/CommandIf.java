package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;

import java.util.List;
import java.util.MissingResourceException;

public class CommandIf extends Command {
    @Override
    public String getDescription() {
        return "if expr is not 0, runs the command(s) given in the list\n" +
                "returns the value of the final command executed (or 0 if no commands are executed)";
    }

    @Override
    public String execute(List<String> params) {
        int openBracket = params.indexOf("[");
        int closeBracket = params.indexOf("]");
        if(openBracket == -1 || closeBracket == -1 || closeBracket < openBracket){
            throw new IllegalArgumentException("Invalid brackets");
        }
        var expressionParams = params.subList(0, openBracket);
        var firstExpressionString = expressionParams.get(0);
        Command firstExpressionCommand = null;
        double expressionValue = -1;
        try{
            firstExpressionCommand = Command.getCommand(firstExpressionString);
        }
        catch(MissingResourceException e){
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
            System.out.println(params);
            closeBracket = params.indexOf("]");
            //var commandParams = params.subList(1, closeBracket);
            params.remove("[");
            var firstCommandStr = params.get(0);
            Command firstCommand = Command.getCommand(firstCommandStr);
            params.remove(0);
            String str=firstCommand.execute(params);

            params.remove("]");
            return str;
        }

    }
}
