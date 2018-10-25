package Backend.Exceptions;

import Backend.CommandManager;

import java.util.ResourceBundle;

public class CommandParsingException extends IllegalArgumentException {
    private static final String MY_Key="CommandParsingException";

    public CommandParsingException(String str){
        super(ResourceBundle.getBundle(CommandManager.ERROR_PATH).getString(MY_Key)+str);
    }
}
