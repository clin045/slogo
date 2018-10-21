package Backend.Commands.Math;

import java.util.List;

public class CommandDiv extends MathCommand {
    private double d1,d2;
    public CommandDiv(){super();}
    @Override
    public String getDescription() {
        return "QUOTIENT: returns quotient of the parameters";
    }



    @Override
    public String execute(List<String> params) {
        System.out.println("PARAMS: "+params.size());
        for(String s:params){System.out.println(s);}
        d1=parseParameters(params);
        double temp=d1;
        System.out.println("d1: "+d1+" d2: "+d2);
        d2=parseParameters(params);
        System.out.println("d1: "+d1+" d2: "+d2+"temp: "+temp);
        if(d2==0){throw new IllegalArgumentException("Cannot divide by 0");}
        return ""+(d1/d2);
    }
}
