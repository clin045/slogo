package Backend;


public class Tester {//Make into Junits
    public static void main (String[]args){
        CommandManager manager = new CommandManager("languages.English");

        String line1="to test [ x 10 ] [ fd :x set :x sum :x 10 if notequalp  :x 100 [ :test ] ]";
 //       String line2 = "bk";
        String out1 = manager.execute(line1);
        System.out.println("OUT1:"+out1);
        //String out2 = manager.execute(line2);
        //System.out.println("OUT2:"+out2);

    }
}
