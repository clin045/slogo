package Backend;

import Backend.CommandManager;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

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
        try {
//            System.out.println("PARAM: "+ params.get(0));
            param=Double.parseDouble(params.get(0));
            params.remove(0);

        }catch (NumberFormatException e){
            try{

                Command nextCmd= getCommand(params.get(0),myTracker);
                if(nextCmd==null){throw new IllegalArgumentException("Can't parse input"+params.get(0));}
                params.remove(0);
                param=Double.parseDouble(nextCmd.execute(params));

            }catch (NumberFormatException e2){
                throw new IllegalArgumentException("Incompatible return types: "+params.get(0));
            }catch (MissingResourceException me){
                if(params.get(0).charAt(0)==':'){
                    Double temp=(Double)myTracker.get(params.get(0).substring(1));
                    if(temp==null){throw new IllegalArgumentException("Variable not defined: "+params.get(0));}
//                System.out.println("Got: x="+temp);
                    params.remove(0);
                    param=temp;
                }
                else{throw new IllegalArgumentException("Variable calls must be preceeded by :");}

            }
        }
        return param;
    }
    public abstract String execute(List <String>params);

    public static Command getCommand(String str, VariableTracker tracker){
        ResourceBundle commandBundle = ResourceBundle.getBundle("config.Commands");
        try{
//            System.out.println(str);
            Class commandStr= Class.forName(commandBundle.getString(str));
            Command command= (Command) commandStr.getDeclaredConstructor(VariableTracker.class).newInstance(tracker);
            return command;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Could not parse command"+str);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not parse command"+str);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("Could not parse command"+str);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Could not parse command"+str);
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException("Could not parse command"+str);
        }
    }


}
