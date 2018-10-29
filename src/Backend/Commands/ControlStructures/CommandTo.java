package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.Commands.BracketedCommand;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public class CommandTo extends BracketedCommand{
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
        if(CommandManager.isCommand(key, myTracker)){throw new IllegalArgumentException("Illegal Command Name");}
            if(myTracker.get(key)!=null){throw new IllegalArgumentException("Command name taken by variable");}
           int endIndex=getCloseIndex(params);

            System.out.println("_______________");
        for(String s:params){System.out.println(s);}
        System.out.println("_______________ endIndex:"+endIndex);
            for(int i=1;i<endIndex;i+=2){//Storing variables
                try {
                    varName = params.get(i);
                    varValue = Double.parseDouble(params.get(i+1));
                    myTracker.put(varName,varValue);
                }catch(NumberFormatException ne){
                    throw new IllegalArgumentException("Variable assignments must be doubles");
                }
            }

            for(int i=0;i<endIndex;i+=1){//removing the variables
                params.remove(0);
            }
            params.remove(0);

            commandList=new ArrayList<>(params.subList(params.indexOf(START_DELIMETER)+1,getCloseIndex(params)));
            for(String s:commandList){System.out.println(s);}
            myTracker.putCommand(key,commandList);
            int end = getCloseIndex(params);

            for(int i=0;i<=end;i+=1){
                params.remove(0);
            }


            params.add(0,":"+key);

        return "";
    }
}
