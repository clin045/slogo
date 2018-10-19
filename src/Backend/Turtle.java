/**
 * @author Max Bartlett
 */

package Backend;

import javafx.geometry.Point2D;
import java.lang.Math;

public class Turtle {
    private Point2D coordinates;
    private double heading; //in degrees
    private boolean penDown;
    private boolean visibility;

    public static final int DEFAULT_X = 0;
    public static final int DEFAULT_Y = 0;
    public static final int DEFAULT_HEADING = 0; //default is facing right
    public static final boolean DEFAULT_PENDOWN = true;
    public static final boolean DEFAULT_VISIBILITY = true;

    /**
     * constructs a Turtle object with custom parameters
     * @param x initial x coordinate
     * @param y initial y coordinate
     * @param heading initial heading
     * @param penDown initial penDown
     * @param visibility initial visibility
     */
    private Turtle(int x, int y, int heading, boolean penDown, boolean visibility) {
        coordinates = new Point2D(x, y);
        this.heading = heading;
        this.penDown = penDown;
        this.visibility = visibility;
    }

    /**
     * constructs a Turtle object with a custom x, y
     * @param x initial x coordinate
     * @param y initial y coordinate
     */
    public Turtle(int x, int y) {
        this(x, y, DEFAULT_HEADING, DEFAULT_PENDOWN, DEFAULT_VISIBILITY);
    }

    /**
     * constructs a Turtle object with default parameters
     */
    public Turtle() {
        this(DEFAULT_X, DEFAULT_Y, DEFAULT_HEADING, DEFAULT_PENDOWN, DEFAULT_VISIBILITY);
    }

    /**
     * @return x coordinate
     */
    public double getX() {
        return coordinates.getX();
    }

    /**
     * @return y coordinate
     */
    public double getY() {
        return coordinates.getY();
    }

    /**
     * @return heading
     */
    public double getHeading() {
        return heading;
    }

    /**
     * @return penDown
     */
    public boolean getPenDown() {
        return penDown;
    }

    /**
     * sets penDown
     * @param penDown new penDown value
     */
    private void setPenDown(boolean penDown) {
        this.penDown = penDown;
    }

    /**
     * @return visibility
     */
    public boolean getVisibility() {
        return visibility;
    }

    /**
     * sets visibility
     * @param visibility new visibility value
     */
    private void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    /**
     * moves coordinates a given distance in the direction of heading
     * @param distance distance to move coordinates
     * @return distance
     */
    private double move(double distance) {
        int dx = (int) Math.floor(distance * Math.cos(Math.toRadians(heading)));
        int dy = (int) Math.floor(distance * Math.sin(Math.toRadians(heading)));
        this.coordinates.add(dx, dy);
        return distance;
    }

    /**
     * moves coordinates a given distance in the direction of heading
     * @param distance distance to move coordinates
     * @return distance
     */
    public double forward(double distance) { return move(distance); }

    /**
     * moves coordinates a given distance in the opposite direction of heading
     * @param distance distance to move coordinates
     * @return distance
     */
    public double back(double distance) {
        return move(distance * -1);
    }

    /**
     * turns heading degrees counterclockwise
     * @param degrees number of degrees to add to heading
     * @return degrees
     */
    public double left(double degrees) {
        setHeading(this.heading + degrees);
        return degrees
    }

    /**
     * turns heading heading degrees clockwise
     * @param degrees number of degrees to subtract from heading
     * @return degrees
     */
    public double right(double degrees) {
        setHeading(this.heading - degrees);
        return degrees;
    }

    /**
     * sets heading to heading
     * @param heading new heading value
     * @return heading
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
     * sets heading to face the point (x, y)
     * @param x x coordinate of the point to turn towards
     * @param y y coordinate of the point to turn towards
     * @return angle between coordinates and (x, y)
     */
    public double towards(double x, double y) {
        return setHeading(coordinates.angle(x, y));
    }

    /**
     * sets coordinates to (x, y)
     * @param x x coordinate
     * @param y y coordinate
     * @return distance from current coordinates to (x, y)
     */
    public double setXY(double x, double y) {
        double distance = coordinates.distance(x, y);
        this.coordinates = new Point2D(x, y);
        return distance;
    }

    /**
     * sets penDown to true
     * @return 1
     */
    public int penDown() {
        setPenDown(true);
        return 1;
    }

    /**
     * sets penDown to false
     * @return 0
     */
    public int penUp() {
        setPenDown(false);
        return 0;
    }

    /**
     * sets visibility to true
     * @return 1
     */
    public int show() {
        setVisibility(true);
        return 1;
    }

    /**
     * sets visiblity to false
     * @return 0
     */
    public int hide() {
        setVisibility(false);
        return 0;
    }

    /**
     * sets x and y to 0
     * @return distance from current point to (0, 0)
     */
    public double home() {
        return setXY(0, 0);
    }
}
