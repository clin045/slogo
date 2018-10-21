package Backend;


public class Tester {//Make into Junits
    public static void main (String[]args){
        CommandManager manager = new CommandManager("languages.English");
        String testInput="make x 5 set x 0 Sum x 5";
        String out=manager.execute(testInput);
        System.out.println("OUT:"+out);
    }
}
