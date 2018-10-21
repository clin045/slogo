package Backend.Commands;

import java.util.List;


public class CommandRand extends MathCommand {
    private double d1;
    public CommandRand(){super();}
    @Override
    public String execute(List<String> params) {
        d1=parseParameters(params);
        if(d1<0){throw new IllegalArgumentException("Random ceiling mus be positive");}
        return ""+ (d1*Math.random());
    }
}
