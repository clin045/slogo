package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class CommandMake extends Command {
    private static final String key="MakeVariable";
    public CommandMake(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }


    @Override
    public String execute(List<String> params) {
        String key=params.get(0);
        ResourceBundle commandBundle=ResourceBundle.getBundle("config.Commands");
        try{
            String command=commandBundle.getString(key);
            throw new IllegalArgumentException("Illegal variable name");
        }catch(MissingResourceException e){
            //Make can override exising values, set cannot create values;
//            if(CommandManager.myTracker.get(key)!=null){throw new IllegalArgumentException("Variable with this name already exists, please use Set to setTurtleToHome the value of this variable");}
            params.remove(0);
            Double value= parseParameter(params);
            super.myTracker.put(key,value);
            return ""+value;
        }

    }
}
