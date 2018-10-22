package Backend.Commands.Math;

import Backend.Command;

import java.util.List;


public class CommandRand extends Command {
    private double d1;
    public CommandRand(){super();}

    @Override
    public String getDescription() {
        return "returns random non-negative number strictly less than max";
    }

    @Override
    public String execute(List<String> params) {
        d1=parseParameters(params);
        if(d1<0){throw new IllegalArgumentException("Random ceiling mus be positive");}
        return ""+ (d1*Math.random());
    }
}
