package Backend;

import Backend.Exceptions.InvalidInputException;
import Backend.Exceptions.InvalidVariableCallException;
import Backend.Exceptions.ParameterAmountException;

import java.util.List;
import java.util.MissingResourceException;

public abstract class Command {

    protected VariableTracker myTracker;
    public Command(VariableTracker tracker){
        myTracker=tracker;
    }


    /**
     *
     * @return description of what the command does to the user
     */
    public abstract String getDescription();

    /**
     * @apiNote parses the parameters needed for command to execute
     * @throws IllegalArgumentException
     */
    public double parseParameters(List<String> params) throws IllegalArgumentException{
        double param;
        if(params.size()==0){throw new ParameterAmountException();}
        if(CommandManager.isCommand(params.get(0))){

            Command nextCmd= CommandManager.getCommand(params.get(0), myTracker);
            params.remove(0);
            param=Double.parseDouble(nextCmd.execute(params));
        }
        else {
            //handle user-defined variables
            if(params.get(0).charAt(0)==':'){
                Double temp=(Double)myTracker.get(params.get(0).substring(1));
                if(temp==null){
                    List<String>userCommand=myTracker.getCommand(params.get(0).substring(1));
                    String commandName=params.get(0);
                    if(userCommand!=null){
                        params.addAll(0,userCommand);
                        params.remove(commandName);
                        return parseParameters(params);

                    }
                    else{throw new IllegalArgumentException("UNKNOWN EXPRESSION: "+params.get(0));}
                }

                else{
                    params.remove(0);
                    param=temp;
                }
                return param;
            }
            try {
                param = Double.parseDouble(params.get(0));
            }
            catch(NumberFormatException e){
                throw new IllegalArgumentException("Invalid parameter");

            }
            params.remove(0);
        }
        return param;
    }
    public abstract String execute(List <String>params);


}
