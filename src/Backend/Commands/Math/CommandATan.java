package Backend.Commands.Math;

import Backend.Commands.Math.MathCommand;

import java.util.List;

public class CommandATan extends MathCommand {
    private double d1;
    public CommandATan(){super();}



    @Override
    public String getDescription() {
        return "ATAN: returns arctangent of degrees";
    }

    @Override
    public String execute(List<String> params) {

        d1=parseParameters(params);
        return ""+(Math.atan(d1));
    }
}
