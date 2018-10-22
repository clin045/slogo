package Backend.Commands.Math;

import Backend.Command;

import java.util.List;

public class CommandCos extends Command {
private double d1;
    public CommandCos(){super();}

    @Override
    public String getDescription() {
        return "COS: return cosine of degrees";
    }

    @Override
    public String execute(List<String> params) {
        d1=parseParameters(params);
        return ""+(Math.cos(d1));
    }
}
