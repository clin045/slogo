package Backend;


public class Tester {//Make into Junits
    public static void main (String[]args){
        CommandManager manager = new CommandManager("languages.English");
        String testInput="repeat 5 [ fd repeat 4 [ SUM 50 10 ] ]";
        String out=manager.execute(testInput);
        System.out.println("OUT:"+out);
    }
}
