package Backend.Commands.Math;

import Backend.Command;

import java.util.List;

public class CommandPi extends Command {
    public CommandPi(){super();}

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String execute(List<String> params) {
        return ""+Math.PI;
    }
}
