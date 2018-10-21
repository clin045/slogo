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
     * @param availibleCommands
     * @return Array of 2 Stacks: Stack 1: contains commands, Stack 2 contains parameters neeeded for those commands
     * @throws IllegalArgumentException
     */
    public List<String> parse(String userInput,Map<String, Command> availibleCommands) throws IllegalArgumentException{
        String[] input = userInput.split(WHITESPACE);
       // System.out.println("Parsing:" +input.length);
        List<String>out=new ArrayList<>();
        Stack<String> functions = new Stack<>();
        Stack<String> arguments = new Stack<>();
        if(input[0].equals("[")){throw new IllegalArgumentException("Brackets can be used to group commands only when preceded by a Control Structures");}
        //if(availibleCommands.get(input[0]).getClass().isInstance(ControlStructure.class)){throw  new RuntimeException("Use parseControl");}
        for (int i=0;i<input.length;i+=1) {
//            System.out.println("LOOP");
            try {
                String symbol=getSymbol(input[i]);
                out.add(symbol);
//                System.out.println("parsing "+symbol);
                if(i<input.length-1){
//                    try {
//                        String symbol2=getSymbol(input[i+1]);
//                        if(availibleCommands.get(symbol2).returnValueAsParam()){
//                            functions.push(symbol);
////                            System.out.println("HAS RETURN VALUE");
//                        }else{
//                            throw new RuntimeException(symbol2 + "is not a valid command because it does not have a return value");
//                        }
//
//                    } catch (IllegalArgumentException e){functions.push(symbol);}
                }

            } catch (IllegalArgumentException e) {
                if (functions.empty()) {
                   out.add(input[i]);
                }//cannot have parameter before a function
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