package Backend.Commands;

import Backend.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandRepeat extends Command {
    private String[] input;
    private int repeatNumber;
    public CommandRepeat(){super();}
    @Override
    public String execute(List<String> params) {
        System.out.println(params.size());
        repeatNumber=(int)parseParameters(params);
        System.out.println("Repeat num: "+repeatNumber);
        System.out.println("param size: "+params.size());
        System.out.println(params.get(0));
        if(!params.get(0).equals("[")||params.indexOf("]")==-1){throw new IllegalArgumentException("Commands inside repeat block need to be surrounded by brackets");}


        String out="";
        double d1=0;
        List<String>temp=new ArrayList<>();
        for (int i=0;i<repeatNumber;i+=1){
            System.out.println("LOOP: "+i+"/"+repeatNumber);
            temp=new ArrayList<>(params);
            temp.remove("[");
            while(temp.size()>0){
                if(temp.get(0).equals("]")){break;}
                if(temp.get(0).equals("[")){break;}
                System.out.println("Temp: ");
                for(String str:temp){System.out.println(str);}
                Command loopCmd=Command.getCommand(temp.get(0));
                System.out.println("got commands");
                temp.remove(0);
                String loop=loopCmd.execute(temp);
                System.out.println("executed: "+loop);
                out+="|"+loop;
                d1+=Double.parseDouble(loop);
            }

        }


        return ""+d1;
    }
}
