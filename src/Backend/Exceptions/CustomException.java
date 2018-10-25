package Backend.Exceptions;

import Backend.CommandManager;

import java.util.ResourceBundle;

public class CustomException extends IllegalArgumentException {
    public CustomException(String key){
        super(ResourceBundle.getBundle(CommandManager.ERROR_PATH).getString(key));
    }
    public CustomException(String key,String message){
        super(ResourceBundle.getBundle(CommandManager.ERROR_PATH).getString(key)+":"+message);
    }
}
