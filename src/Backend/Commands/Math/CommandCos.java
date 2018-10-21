package Backend.Commands.Math;

import java.util.List;

public class CommandCos extends MathCommand{
private double d1;
    public CommandCos(){super();}
    @Override
    public String execute(List<String> params) {
        d1=parseParameters(params);
        return ""+(Math.cos(d1));
    }
}
