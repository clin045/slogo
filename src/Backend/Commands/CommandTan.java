package Backend.Commands;

import java.util.List;

public class CommandTan extends MathCommand{
private double d1;
public CommandTan(){super();}
    @Override
    public String execute(List<String> params) {
        d1=parseParameters(params);
        if(d1%180==0){throw new IllegalArgumentException("tan of multiples of 180 is undefined");}
        return ""+(Math.tan(d1));
    }
}
