package Backend;


import Backend.Commands.CommandManager;

public class Tester {//Make into Junits
    public static void main (String[]args){
        CommandManager manager = new CommandManager("languages.English");
        String testInput="FD 50 RT 70 LT 50 BK 50 SETH 15";
        String out=manager.execute(testInput);
    }
}
