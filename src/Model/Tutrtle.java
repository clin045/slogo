
import java.util.*;

/**
 * 
 */
public interface Tutrtle {

    /**
     * 
     */
    public double getX();

    /**
     * 
     */
    public double getY();

    /**
     * @param x
     * @param y
     */
    public void move( double x,  double y);

    /**
     * @param  x
     * @param  y
     */
    public void turn(double x,  double y);

    /**
     * 
     */
    public void getOrientation();

}