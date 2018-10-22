package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class CommandTo extends Command {
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
            if(CommandManager.myTracker.get(key)!=null){throw new IllegalArgumentException("Command name taken by variable");}
            params.remove(0);
            int counter=0;
            for(int i=0;i<params.indexOf("]");i+=2){//Storing variables
                try {
                    varName = params.get(i);
                    varValue = Double.parseDouble(params.get(i+1));
                    System.out.println("Storing: "+ varName+" = "+varValue);
                    CommandManager.myTracker.put(varName,varValue);
                }catch(NumberFormatException ne){
                    throw new IllegalArgumentException("Variable assignments must be doubles");
                }
            }
            params.remove("]");
            commandList=new ArrayList<>(params.subList(params.indexOf("[")+1,params.indexOf("]")));
            CommandManager.myTracker.putCommand(key,commandList);
            for(int i=0;i<=params.indexOf("]");i+=1){
                params.remove(0);
            }
            params.remove("]");

            System.out.println("PARAMS:"+params.size());

        }
        return CommandManager.myTracker.executeCommand(key);
    }
}
