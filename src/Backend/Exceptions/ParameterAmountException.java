package Backend.Exceptions;

import Backend.CommandManager;

import java.util.ResourceBundle;

public class ParameterAmountException extends IllegalArgumentException {
    private static final String MY_KEY="ParameterAmountException";
    public ParameterAmountException(){
        super(ResourceBundle.getBundle(CommandManager.ERROR_PATH).getString(MY_KEY));
    }
}
