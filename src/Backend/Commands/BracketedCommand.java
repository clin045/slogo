package Backend.Commands;

import Backend.Command;
import Backend.CommandManager;
import Backend.Exceptions.InvalidInputException;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public abstract class BracketedCommand extends Command {
    public BracketedCommand(VariableTracker tracker){
        super(tracker);
    }


    @Override
    public abstract String execute(List<String> params);

    protected int getCloseIndex(List<String> str){
        int startIndex=str.indexOf("[");
        if(startIndex<=-1||str.indexOf("]")<startIndex){
            throw new IllegalArgumentException("Need [");
        }
        int numOpen=1;
        int numClosed=0;
        for(int index =startIndex+1;index<str.size();index+=1){
            if(str.get(index).equals("[")){
                numOpen+=1;
            }
            if(str.get(index).equals("]")){
                numClosed+=1;
            }
            if(numOpen==numClosed){
                return index;
            }
        }
        throw new IllegalArgumentException("Brackets don't match");
    }


    protected ArrayList<Double> evaluateBrackets(List<String> exp) {
        System.out.println("---");
        System.out.println(exp);
        exp.remove("[");
        exp.remove("]");
        //check if each param is a command, if so, evaluate it
        var retList = new ArrayList<Double>();
        while(exp.size() > 0){
            if(CommandManager.isCommand(exp.get(0), myTracker)){
                var cmd = CommandManager.getCommand(exp, myTracker);
                exp.remove(0);
                try{
                    System.out.println("Expanded:" + exp);
                    var doubVal = Double.parseDouble(cmd.execute(exp));
                    retList.add(doubVal);
                }
                catch(Exception e){
                    System.out.println(e);
                    throw new IllegalArgumentException("Invalid params for bracketed expression");
                }
            }
            else{
                try{
                    retList.add(Double.parseDouble(exp.get(0)));
                    exp.remove(0);
                }
                catch(Exception e){
                    System.out.println(e);
                    throw new IllegalArgumentException("Invalid params for bracketed expression");
                }
            }
        }
        return retList;
    }

}
