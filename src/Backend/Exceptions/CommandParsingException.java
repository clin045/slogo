package Backend.Exceptions;

public class CommandParsingException extends CustomException {
    private static String MY_Key="CommandParsingException";

    public CommandParsingException(String str){
        super(MY_Key);
    }
}
