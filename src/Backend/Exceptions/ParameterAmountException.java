package Backend.Exceptions;

import Backend.CommandManager;

import java.util.ResourceBundle;

public class ParameterAmountException extends CustomException {
    private static String MY_KEY="ParameterAmountException";
    public ParameterAmountException(){
        super(MY_KEY);
    }
}
