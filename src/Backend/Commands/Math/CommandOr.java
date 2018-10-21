package Backend.Commands.Math;

import Backend.Command;

import java.util.List;

public class CommandOr extends Command {
    @Override
    public String getDescription() {
        return "returns 1 if test1 or test2 are non-zero, otherwise 0";
    }

    @Override
    public String execute(List<String> params) {
        double test1 = parseParameters(params);
        double test2 = parseParameters(params);
        if(test1 != 0 || test2 != 0){
            return "1";
        }
        else{
            return "0";
        }
    }
}
