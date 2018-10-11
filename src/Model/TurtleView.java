package Model;

/**
 * 
 */
public interface TurtleView {

    /**
     * @param  command
     */
    public void addCommand(String command);

    /**
     * @param  x
     * @param  y
     */
    public void addPosition( int x,  int y);

    /**
     * 
     */
    public int[] getPosition();

    /**
     * 
     */
    public void updateTurtle();

}