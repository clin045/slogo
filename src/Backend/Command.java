package Backend;

import Backend.Exceptions.InvalidInputException;
import Backend.Exceptions.ParameterAmountException;

import java.util.List;
import java.util.ResourceBundle;

public abstract class Command {

    protected VariableTracker myTracker;
    public static final String DESCRIPTION_PATH="Config.CommandDescriptions";
    private String myKey="Default";
    public Command(VariableTracker tracker){
        myTracker=tracker;
    }
    /**
     *
     * @return description of what the command does to the user
     */
    protected void setKey(String key){myKey=key;}
    public String getDescription(){
        return ResourceBundle.getBundle(DESCRIPTION_PATH).getString(myKey);
    }

    /**
     * @apiNote parses the parameters needed for command to execute
     * @throws IllegalArgumentException
     */
    public double parseParameter(List<String> params) throws IllegalArgumentException{
        double param;
        if(params.size()==0){throw new ParameterAmountException();}
        if(CommandManager.isCommand(params.get(0), myTracker)){

            Command nextCmd= CommandManager.getCommand(params, myTracker);
            params.remove(0);
            param=Double.parseDouble(nextCmd.execute(params));
        }
        else {
            //handle user-defined variables
            if(params.get(0).charAt(0)==':'){
                return handleCustomInput(params);
            }
            try {
                param = Double.parseDouble(params.get(0));
            }
            catch(NumberFormatException e){
                throw new InvalidInputException(params.get(0));

            }
            params.remove(0);
        }
        return param;
    }

    private double handleCustomInput(List<String> params) {
        double param;
        Double temp=(Double)myTracker.get(params.get(0).substring(1));
        if(temp==null){
            List<String>userCommand=myTracker.getCommand(params.get(0).substring(1));
            String commandName=params.get(0);
            if(userCommand!=null){
                params.addAll(0,userCommand);
                params.remove(commandName);
                return parseParameter(params);

            }
            else{throw new InvalidInputException(params.get(0));}
        }

        else{
            params.remove(0);
            param=temp;
        }
        return param;
    }


    public abstract String execute(List <String>params);


}
