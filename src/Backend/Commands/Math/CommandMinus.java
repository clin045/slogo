package Backend.Commands.Math;

import Backend.Command;

import java.util.List;

public class CommandMinus extends Command {
    double d1;

    public CommandMinus(){super();}

    @Override
    public String getDescription() {
        return "returns negative of the values of expr";
    }

    @Override
    public String execute(List<String> params) {
        d1=parseParameters(params);
        return ""+(-1*d1);
    }
}
