package Backend.Exceptions;

import Backend.CommandManager;

import java.util.ResourceBundle;

public class InvalidVariableCallException extends IllegalArgumentException {
    public static final String MY_KEY="InvalidVariableCallException";
    public InvalidVariableCallException(){
        super(ResourceBundle.getBundle(CommandManager.ERROR_PATH).getString(MY_KEY));
    }
}
