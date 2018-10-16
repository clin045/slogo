package Backend;

public class Tester {
    public static void main (String[]args){
        CommandManager manager = new CommandManager("C:\\Users\\Christopher\\308\\slogo_team02\\data\\languages\\English.properties");
        String testInput="FD 50 FD 50 FD 50";
        String out=manager.execute(testInput);
    }
}
