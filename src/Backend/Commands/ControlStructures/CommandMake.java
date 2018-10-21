package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class CommandMake extends Command {
    public CommandMake(){super();}

    @Override
    public String getDescription() {
        return "Creates a new variable or overrides value of the last one";
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
//            if(CommandManager.myTracker.get(key)!=null){throw new IllegalArgumentException("Variable with this name already exists, please use Set to reset the value of this variable");}
            params.remove(0);
            Double value= parseParameters(params);
            CommandManager.myTracker.put(key,value);
            return ""+value;
        }

    }
}
