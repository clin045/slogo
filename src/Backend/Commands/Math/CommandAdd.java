package Backend.Commands.Math;

import Backend.Command;

import java.util.List;

/**
 * @author Michael Glushakov (mg367)
 */
public class CommandAdd extends Command {
    private Double d1,d2;
    public CommandAdd() {
        super();
    }

    @Override
    public String getDescription() {
        return "SUM returns the sum of 2 numbers";
    }



    @Override
    public String execute(List<String>params) {
//        System.out.println("PARAMS: "+params.size());
//        for(String s:params){System.out.println(s);}
        d1=parseParameters(params);
        double temp=d1;
//        System.out.println("d1: "+d1+" d2: "+d2);
        d2=parseParameters(params);
//        System.out.println("d1: "+d1+" d2: "+d2+"temp: "+temp);
        return ""+(d1+d2);
    }
}
