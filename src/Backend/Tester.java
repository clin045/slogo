package Backend;


public class Tester {//Make into Junits
    public static void main (String[]args){
        CommandManager manager = new CommandManager("languages.English");
        String testInput="for [ x 1 5 1 ] [ repeat 5 [ fd x ] ]";
        String out=manager.execute(testInput);
        System.out.println("OUT:"+out);
    }
}
