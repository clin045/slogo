package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class CommandSet extends Command {
    private static final String key = "SetVariable";

    public CommandSet(VariableTracker tracker) {
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        String key = params.get(0);
        ResourceBundle commandBundle = ResourceBundle.getBundle("config.Commands");
        try {
            String command = commandBundle.getString(key);
            throw new InvalidSyntaxException(key);
        } catch (MissingResourceException e) {
            //Make can override exising values, set cannot create values;
            if (super.myTracker.get(key) == null) {
                throw new InvalidSyntaxException(key);
            }
            params.remove(0);
            Double value;
            try {
                value = parseParameter(params);
            } catch (Exception e2) {
                throw new InvalidSyntaxException(key);
            }
            super.myTracker.put(key, value);
            return String.valueOf(value);
        }
    }
}
