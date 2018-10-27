package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class CommandTo extends Command {
    private final String END_DELIMETER="]";
    private final String START_DELIMETER="[";
    private static final String myKey="MakeUserInstruction";
    public CommandTo(VariableTracker tracker){
        super(tracker);
        setKey(myKey);
    }


    @Override
    public String execute(List<String> params) {
        List<String>commandList;
        String varName;
        double varValue;
        if(params.get(0).equals(START_DELIMETER)){throw new IllegalArgumentException("To needs a variable name to store the commands");}
        String key=params.remove(0);//[
        if(CommandManager.isCommand(key)){throw new IllegalArgumentException("Illegal Command Name");}
            if(myTracker.get(key)!=null){throw new IllegalArgumentException("Command name taken by variable");}
            params.remove(0);
            for(int i=0;i<params.indexOf(END_DELIMETER);i+=2){//Storing variables
                try {
                    varName = params.get(i);
                    varValue = Double.parseDouble(params.get(i+1));
                    myTracker.put(varName,varValue);
                }catch(NumberFormatException ne){
                    throw new IllegalArgumentException("Variable assignments must be doubles");
                }
            }
            int endIndex=params.indexOf(END_DELIMETER);
            for(int i=0;i<endIndex;i+=1){
                params.remove(0);
            }
            params.remove(0);

            commandList=new ArrayList<>(params.subList(params.indexOf(START_DELIMETER)+1,params.indexOf(END_DELIMETER)));
            myTracker.putCommand(key,commandList);
            int end = params.indexOf(END_DELIMETER);

            for(int i=0;i<=end;i+=1){

                params.remove(0);
            }


            params.add(0,":"+key);


        return "";
    }
}
