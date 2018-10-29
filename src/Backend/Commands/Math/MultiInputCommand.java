/**
 * @author Michael Glushakov (mg367)
 */
package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidInputException;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public class MultiInputCommand extends Command{
    protected List<Double> myVals;
    public MultiInputCommand(VariableTracker tracker){
        super(tracker);
        myVals= new ArrayList<>();
    }

    protected void parseAllParameters(List<String>params){
        if(params.get(0).equals("(")){
            if(!params.contains(")")){throw new InvalidInputException();
            }
            params.remove(0);
            int end=params.indexOf(")");
            for(int i = 0; i < end; i += 1){
                if(params.get(0).equals(")")){
                    params.remove(0);
                    break;
                }
                myVals.add(parseParameter(params));
            }
            if(params.size()>0&&params.get(0).equals(")")){
                params.remove(0);
            }
        } else {
            myVals.add(parseParameter(params));
            myVals.add(parseParameter(params));
        }
    }

    @Override
    public String execute(List<String> params) {
        return null;
    }
}