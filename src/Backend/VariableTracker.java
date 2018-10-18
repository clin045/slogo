package Backend;

public class VariableTracker {
    public Turtle getTurtle() {
        return myTurtle;
    }

    private Turtle myTurtle;
    public VariableTracker(){
        myTurtle = new Turtle();
    }
}
