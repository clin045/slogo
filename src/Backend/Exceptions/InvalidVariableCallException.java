package Backend.Exceptions;

import Backend.CommandManager;

import java.util.ResourceBundle;

public class InvalidVariableCallException extends CustomException {
    public static String MY_KEY="InvalidVariableCallException";
    public InvalidVariableCallException(){
        super(MY_KEY);
    }
}
