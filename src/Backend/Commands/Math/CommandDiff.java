package Backend.Commands.Math;

import Backend.Command;

import java.util.List;

/**
 * @author Michael Glushakov mg367
 */
public class CommandDiff extends Command {
    private double d1,d2;

    public CommandDiff(){
        super();

    }
    @Override
    public String getDescription() {
        return "DIFFERENCE: returns difference of the arguments";
    }


    @Override
    public String execute(List<String> params) {
//        System.out.println("PARAMS: "+params.size());
//        for(String s:params){System.out.println(s);}
        d1=parseParameters(params);
        double temp=d1;
//        System.out.println("d1: "+d1+" d2: "+d2);
        d2=parseParameters(params);
//        System.out.println("d1: "+d1+" d2: "+d2+"temp: "+temp);
        return ""+(d1-d2);
    }
}
