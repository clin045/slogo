package Backend.Commands;

import java.util.List;

public class CommandATan extends MathCommand {
    private double d1;
    public CommandATan(){super();}
    @Override
    public String execute(List<String> params) {

        d1=parseParameters(params);
        return ""+(Math.atan(d1));
    }
}
