package Backend.Exceptions;

import Backend.CommandManager;

import java.util.ResourceBundle;

public class InvalidSyntaxException extends CustomException {
    public static final String MY_KEY = "InvalidSyntax";

    public InvalidSyntaxException(String cmdKey){
        super(MY_KEY, ResourceBundle.getBundle(CommandManager.SYNTAX_PATH).getString(cmdKey));
    }
}
