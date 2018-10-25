package Backend.Exceptions;

import java.util.ResourceBundle;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException(){
        super(ResourceBundle.getBundle("config.Errors").getString("InvalidInputException"));
    }
    public InvalidInputException(String str){
        super(ResourceBundle.getBundle("config.Errors").getString("InvalidInputException")+":"+str);
    }
}
