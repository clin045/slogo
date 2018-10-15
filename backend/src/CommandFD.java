public class CommandFD implements Command {
    public CommandFD(){}

    @Override
    public int getParamNumber() {
        return 1;
    }
    @Override
    public String getDescription(){
        return "FORWARD: Moves Turtle forward by a set amount of pixels";
    }
}
