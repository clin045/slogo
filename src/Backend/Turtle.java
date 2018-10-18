/**
 * @author Max Bartlett
 */

package Backend;
import java.awt.*;
import java.lang.Math;

public class Turtle {
    private Point coordinates;
    private double heading; //in degrees
    private boolean penDown;
    private boolean visibility;

    public static final int DEFAULT_X = 0;
    public static final int DEFAULT_Y = 0;
    public static final int DEFAULT_HEADING = 0; //default is facing right
    public static final boolean DEFAULT_PENDOWN = true;
    public static final boolean DEFAULT_VISIBILITY = true;

    /**
     *
     */
    private Turtle(int x, int y, int heading, boolean penDown, boolean visibility) {
        coordinates = new Point(x, y);
        this.heading = heading;
        this.penDown = penDown;
        this.visibility = visibility;
    }

    /**
     * @param x
     * @param y
     */
    public Turtle(int x, int y) {
        this(x, y, DEFAULT_HEADING, DEFAULT_PENDOWN, DEFAULT_VISIBILITY);
    }

    /**
     *
     */
    public Turtle() {
        this(DEFAULT_X, DEFAULT_Y, DEFAULT_HEADING, DEFAULT_PENDOWN, DEFAULT_VISIBILITY);
    }

    /**
     * @return
     */
    public int getX() {
        return coordinates.x;
    }

    /**
     * @return
     */
    public int getY() {
        return coordinates.y;
    }

    /**
     * @return
     */
    public double getHeading() {
        return heading;
    }

    /**
     * @return
     */
    public boolean getPenDown() {
        return penDown;
    }

    /**
     *
     */
    private void setPenDown(boolean penDown) {
        this.penDown = penDown;
    }

    /**
     * @return
     */
    public boolean getVisibility() {
        return visibility;
    }

    /**
     *
     */
    private void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    /**
     * @param distance
     */
    private int move(int distance) {
        int dx = (int) Math.floor(distance * Math.cos(Math.toRadians(heading)));
        int dy = (int) Math.floor(distance * Math.sin(Math.toRadians(heading)));
        this.coordinates.move(dx, dy);
        return distance;
    }

    /**
     * @param distance
     * @return
     */
    public int moveForward(int distance) {
        return move(distance);
    }

    /**
     * @param distance
     */
    public int moveBack(int distance) {
        return move(distance * -1);
    }

    /**
     * @param heading
     * @return
     */
    public double left(double heading) {
        return setHeading(this.heading + heading);
    }

    /**
     * @param heading
     * @return
     */
    public double right(double heading) {
        return setHeading(this.heading - heading);
    }

    /**
     * @param heading
     * @return
     */
    public double setHeading(double heading) {
        if (heading < 0 || heading > 360) {
            if (heading < 0) {
                heading += 360;
            }
            heading %= 360;
        }
        this.heading = heading;
        return heading;
    }

    /**
     * @param cx
     * @param cy
     * @return
     */
    //https://stackoverflow.com/questions/46387747/find-angle-of-point-on-circle
    //double check this
    public double towards(int cx, int cy) {
        double theta = (Math.abs(heading - Math.toDegrees(Math.atan2(coordinates.y - cy, coordinates.x - cx))));
        setHeading(theta);
        return theta;
    }

    /**
     * @param x
     * @param y
     */
    public double setXY(int x, int y) {
        double distance = coordinates.distance(x, y);
        this.coordinates.setLocation(x, y);
        return distance;
    }

    /**
     * @return
     */
    public int penDown() {
        setPenDown(true);
        return 1;
    }

    /**
     * @return
     */
    public int penUp() {
        setPenDown(false);
        return 0;
    }

    /**
     * @return
     */
    public int show() {
        setVisibility(true);
        return 1;
    }

    /**
     * @return
     */
    public int hide() {
        setVisibility(false);
        return 0;
    }

    /**
     * @return
     */
    public double home() {
        return setXY(0, 0);
    }
}
