package Backend.Commands.Math;

import Backend.Command;

import java.util.List;

public class CommandSin extends Command {
   private double d1;
    public CommandSin(){super();}

    @Override
    public String getDescription() {
        return "returns sine of degrees";
    }

    @Override
    public String execute(List<String> params) {
        d1=parseParameters(params);
        return ""+ (Math.sin(d1));
    }
}
