import java.util.ResourceBundle;

public class Tester {
    public static void main (String[]args){
        CommandManager manager = new CommandManager("resources/languages/English");
        String testInput="FD 50 FD 50 FD 50";
        String out=manager.execute(testInput);
    }
}
