package Backend;

public class Tester {
    public static void main (String[]args){
        CommandManager manager = new CommandManager("languages.English");
        String testInput="FD 50 FD 50 FD 50";
        String out=manager.execute(testInput);
    }
}
