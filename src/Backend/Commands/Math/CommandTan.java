package Backend.Commands.Math;

import Backend.Command;

import java.util.List;

public class CommandTan extends Command {
private double d1;
public CommandTan(){super();}

    @Override
    public String getDescription() {
        return "returns tangent of degrees";
    }

    @Override
    public String execute(List<String> params) {
        d1=parseParameters(params);
        if(d1%180==0){throw new IllegalArgumentException("tan of multiples of 180 is undefined");}
        return ""+(Math.tan(d1));
    }
}
