package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class CommandTo extends Command {
    public CommandTo(VariableTracker tracker){
        super(tracker);
    }
    @Override
    public String getDescription() {
        return "assigns command(s) given in the second list to commandName using parameters given in first list as variables";
    }

    @Override
    public String execute(List<String> params) {
        List<String>commandList;
        String varName;
        double varValue;
        if(params.get(0).equals("[")){throw new IllegalArgumentException("To needs a variable name to store the commands");}

        String key=params.remove(0);//[
        try{
            ResourceBundle commandBundle = ResourceBundle.getBundle("config.Commands");
            String str=commandBundle.getString(key);
                throw new IllegalArgumentException("Illegal Command Name");

        }catch (MissingResourceException me){
            if(super.myTracker.get(key)!=null){throw new IllegalArgumentException("Command name taken by variable");}
            params.remove(0);
            int counter=0;
            for(int i=0;i<params.indexOf("]");i+=2){//Storing variables
                try {
                    varName = params.get(i);
                    varValue = Double.parseDouble(params.get(i+1));
                    super.myTracker.put(varName,varValue);
                }catch(NumberFormatException ne){
                    throw new IllegalArgumentException("Variable assignments must be doubles");
                }
            }
            int endIndex=params.indexOf("]");
            for(int i=0;i<endIndex;i+=1){//Storing variables
                params.remove(0);
            }
            params.remove(0);
            for(String s: params){System.out.println(s);}
            commandList=new ArrayList<>(params.subList(params.indexOf("[")+1,params.indexOf("]")));
            super.myTracker.putCommand(key,commandList);
            int end = params.indexOf("]");
            System.out.println("PARAMS:"+params.size());
            for(int i=0;i<=end;i+=1){
                System .out.println("Removing");
                params.remove(0);
            }
            params.remove("]");

            System.out.println("PARAMS:"+params.size());
            params.add(0,":"+key);

        }
        return super.myTracker.executeCommand(key);
    }
}
