package Backend.Commands.Math;

import java.util.List;

public class CommandPow extends MathCommand {
    private double d1,d2;
    public CommandPow(){super();}
    @Override
    public String execute(List<String> params) {
        d1=parseParameters(params);
        d2=parseParameters(params);
        return ""+Math.pow(d1,d2);
    }
}
