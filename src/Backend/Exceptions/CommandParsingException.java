package Backend.Exceptions;

import Backend.CommandManager;

import java.util.ResourceBundle;

public class CommandParsingException extends CustomException {
    private static String MY_Key="CommandParsingException";

    public CommandParsingException(String str){
        super(MY_Key);
    }
}
