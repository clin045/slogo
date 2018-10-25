package Backend.Exceptions;

import Backend.CommandManager;

import java.util.ResourceBundle;

public class InvalidInputException extends IllegalArgumentException {
    public static final String MY_KEY="InvalidInputException";
    public InvalidInputException(){
        super(ResourceBundle.getBundle(CommandManager.ERROR_PATH).getString(MY_KEY));
    }
    public InvalidInputException(String str){
        super(ResourceBundle.getBundle(CommandManager.ERROR_PATH).getString(MY_KEY)+":"+str);
    }
}
