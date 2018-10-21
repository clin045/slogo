package Backend;

import Backend.Commands.CommandManager;

import java.util.List;

public abstract class Command {
    private int myParamNumber;
    protected VariableTracker myTracker;
    private String myDescription;

    public Command(VariableTracker tracker){myTracker=tracker;}
    /**
     *
     * @return number of parameters
     */
    public int getParamNumber(){
        return myParamNumber;
    };

    /**
     *
     * @return description of what the command does to the user
     */
    public String getDescription(){return myDescription;};

    /**
     * @apiNote parses the parameters needed for command to execute
     * @throws IllegalArgumentException
     */
    public double parseParameters(List<String> params) throws IllegalArgumentException{
        double param;
        try {
            param=Double.parseDouble(params.get(0));
            params.remove(0);

        }catch (NumberFormatException e){
            try{
                Command nextCmd= CommandManager.getCommand(params.get(0));
                if(nextCmd==null){throw new IllegalArgumentException("Can't parse input"+params.get(0));}
                params.remove(0);
                param=Double.parseDouble(nextCmd.execute(params));

            }catch (NumberFormatException e2){
                throw new IllegalArgumentException("Incompatible return types: "+params.get(0));
            }
        }
        return param;
    }
    public abstract String execute(List <String>params);


}
