package Backend;

import Backend.Command;
import Backend.TextParser;
import Backend.VariableTracker;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.ResourceBundle;

/**
 * @author Michael Glushakov (mg367)
 */
public class CommandManager {

    private static final Map<String, Command>myCommands= new HashMap<>();
    private TextParser myParser;
    public static final VariableTracker myTracker=new VariableTracker();


    /**
     * default constructor
     */
    public CommandManager(){
        myParser=new TextParser();

    };

    /**
     * Constructor with a predefined language
     * @param path path to the resource bundle containing the language specific commands
     */
    public CommandManager(String path){

       myParser=new TextParser(path);

    }

    public String execute(String userInput){
        String out="";
        List<String>parsedList = myParser.parse(userInput);
        while(parsedList.size()>0){
            Command init=Command.getCommand(parsedList.get(0));
            if(init==null){throw new IllegalArgumentException("Invalid input");}
            parsedList.remove(0);
            out+=init.execute(parsedList);
        }

        return out;
    }

}
