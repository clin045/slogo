package Backend;


public class Tester {//Make into Junits
    public static void main (String[]args){
        CommandManager manager = new CommandManager("languages.English");
        String testInput="if sum 1 2 [ fd 50 ] bk 10";
        String out=manager.execute(testInput);
        System.out.println("OUT:"+out);
    }
}
