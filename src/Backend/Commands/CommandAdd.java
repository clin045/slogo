package Backend.Commands;

import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Glushakov (mg367)
 */
public class CommandAdd extends MathCommand{
    private Double d1,d2;
    public CommandAdd(VariableTracker tracker) {
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "SUM returns the sum of 2 numbers";
    }



    @Override
    public String execute(List<String>params) {
        System.out.println("PARAMS: "+params.size());
        for(String s:params){System.out.println(s);}
        d1=parseParameters(params);
        double temp=d1;
        System.out.println("d1: "+d1+" d2: "+d2);
        List params2=new ArrayList(params);
        d2=parseParameters(params);
//        params=params2;
        System.out.println("d1: "+d1+" d2: "+d2+"temp: "+temp);
        d1=temp;
        return ""+(d1+d2);
    }
}
