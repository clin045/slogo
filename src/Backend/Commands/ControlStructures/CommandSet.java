package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class CommandSet extends Command {
    public CommandSet(VariableTracker tracker){super(tracker);}


    @Override
    public String getDescription() {
        return "Sets a value of a variable";
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
            if(super.myTracker.get(key)==null){throw new IllegalArgumentException("Variable not found, please use MAKE to create new variable");}
            params.remove(0);
            Double value= parseParameters(params);
            super.myTracker.put(key,value);
            return ""+value;
    }

    }
}
