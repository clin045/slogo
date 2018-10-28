package Backend;


public class Tester {//Make into Junits
    public static void main (String[]args){
        CommandManager manager = new CommandManager("languages.English");

        String line1="fd 10";
 //       String line2 = "bk";
        String out1 = manager.execute(line1);
        System.out.println("OUT1:"+out1);
   //     String out2 = manager.execute(line2);
//        System.out.println("OUT2:"+out2);

    }
}
