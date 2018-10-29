package Backend;

//import Backend.Commands.ControlStructure;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author Michael Glushakov (mg367)
 */

public class TextParser {
    private List<Map.Entry<String, Pattern>> mySymbols;
    public static final String WHITESPACE = "\\s+";

    /**
     * @apiNote Default constructor
     */
    public TextParser() {
        mySymbols = new ArrayList<>();
    }

    /**
     * Constructor with path of the initial language file
     * @param path to the initial language file
     */
    public TextParser(String path) {
        mySymbols = new ArrayList<>();
        setLanguage(path);
    }

    /**
     * @param path: url path to the properties file location
     * @author Robert C. Duvall
     * @apiNote sets the language o be recognized by the parser
     */
    protected void setLanguage(String path) {
        mySymbols.clear();
        ResourceBundle languageBundle = ResourceBundle.getBundle(path);
        for (var key : Collections.list(languageBundle.getKeys())) {
            var regex = languageBundle.getString(key);
            mySymbols.add(new AbstractMap.SimpleEntry<>(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
    }

    /**
     *
     * @param userInput
     * @return Array of 2 Stacks: Stack 1: contains commands, Stack 2 contains parameters neeeded for those commands
     * @throws IllegalArgumentException
     */
    public List<String> parse(String userInput) throws IllegalArgumentException{
        String[] input = userInput.split(WHITESPACE);
        List<String>out=new ArrayList<>();
        Stack<String> functions = new Stack<>();
        Stack<String> arguments = new Stack<>();
        if(input[0].equals("[")){   throw new IllegalArgumentException("Brackets can be used to group commands only when preceded by a Control Structures");}
        for (int i=0;i<input.length;i+=1) {
            try {
                String symbol=getSymbol(input[i]);
                out.add(symbol);

            } catch (IllegalArgumentException e) {
                if (functions.empty()) {
                   out.add(input[i]);
                }
                arguments.push(input[i]);
            }
        }

        return out;
    }

    /**
     * @param text
     * @return the String matcing the key in the Backend.Command Map
     * @throws IllegalArgumentException
     * @author Robert C. Duvall
     * @author Michael Glushakov (mg367)
     */
    private String getSymbol(String text) throws IllegalArgumentException {
        final String ERROR = "INVALID EXPRESSION: ";
        for (var e : mySymbols) {
            if (e.getValue().matcher(text).matches()) {
                return e.getKey();
            }
        }
        throw new IllegalArgumentException(ERROR + text);
    }
}