package Backend.Commands.Math;

import java.util.List;

public class CommandSin extends MathCommand {
   private double d1;
    public CommandSin(){super();}
    @Override
    public String execute(List<String> params) {
        d1=parseParameters(params);
        return ""+ (Math.sin(d1));
    }
}
