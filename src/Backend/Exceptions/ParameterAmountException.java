package Backend.Exceptions;

public class ParameterAmountException extends CustomException {
    private static String MY_KEY="ParameterAmountException";
    public ParameterAmountException(){
        super(MY_KEY);
    }
}
