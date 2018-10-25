package Backend;

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
        if(params.size()==0){throw new IllegalArgumentException("Not enough arguments");}
        if(CommandManager.isCommand(params.get(0))){
            try{
                Command nextCmd= CommandManager.getCommand(params.get(0), myTracker);
                params.remove(0);
                param=Double.parseDouble(nextCmd.execute(params));

            }catch (NumberFormatException e2){
                throw new IllegalArgumentException("Incompatible return types: "+params.get(0));
            }catch (MissingResourceException me){
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

                }
                else{throw new IllegalArgumentException("Variable calls must be preceeded by :");}

            }
        }
        else {
//            System.out.println("PARAM: "+ params.get(0));
            param=Double.parseDouble(params.get(0));
            params.remove(0);
        }


        return param;
    }
    public abstract String execute(List <String>params);


}
