package Backend.Commands.Math;

import java.util.List;

public class CommandLog extends MathCommand {
    private double d1;
    public CommandLog(){super();}

    @Override
    public String getDescription() {
        return "LOG: returns natural log of expr";
    }

    @Override
    public String execute(List<String> params) {
        d1=parseParameters(params);
        if(d1<0){throw new IllegalArgumentException("Log input must be positive");}
        return ""+(Math.log(d1));
    }
}
