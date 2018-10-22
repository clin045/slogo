package Backend;


public class Tester {//Make into Junits
    public static void main (String[]args){
        CommandManager manager = new CommandManager("languages.English");

        String testInput="to testCommand [ x 5 y 10 ] [ fd sum x y ] testCommand";
        String out=manager.execute(testInput);
        System.out.println("OUT:"+out);
    }
}
