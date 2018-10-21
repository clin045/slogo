package Backend.Commands.Math;

import java.util.List;

public class CommandPi extends MathCommand{
    public CommandPi(){super();}
    @Override
    public String execute(List<String> params) {
        return ""+Math.PI;
    }
}
