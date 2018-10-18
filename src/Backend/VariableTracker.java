package Backend;

public class VariableTracker {
    public Turtle getTurtle() {
        return myTurtle;
    }

    private Turtle myTurtle;
    VariableTracker(){
        myTurtle = new Turtle();
    }
}
