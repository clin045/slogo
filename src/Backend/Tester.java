package Backend;


public class Tester {//Make into Junits
    public static void main (String[]args){
        CommandManager manager = new CommandManager("languages.English");

        String testInput="tell [ 0 1 ]";
        String out=manager.execute(testInput);
        System.out.println("OUT:"+out);
    }
}
