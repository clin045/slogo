package Backend.Commands;

import java.util.List;

public class CommandMinus extends MathCommand {
    double d1;

    public CommandMinus(){super();}

    @Override
    public String execute(List<String> params) {
        d1=parseParameters(params);
        return ""+(-1*d1);
    }
}
