package Backend;


import Backend.Commands.CommandManager;

public class Tester {//Make into Junits
    public static void main (String[]args){
        CommandManager manager = new CommandManager("languages.English");
        String testInput="SUM 12 SUM 7 6";
        String out=manager.execute(testInput);
        System.out.println("OUT:"+out);
    }
}
