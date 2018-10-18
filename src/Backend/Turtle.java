package Backend;

public class Turtle {
    //orientation in degrees. Straight up is at 0 degrees.
    private double myOrientation;
    Turtle(){
        myOrientation = 0;
    }
    public void move(int dist){
        System.out.println("moving " +dist);
    }
    public double getOrientation(){
        return myOrientation;
    }
    public void setOrientation(double newOrientation){
        myOrientation = newOrientation;
        if(myOrientation < 0){
            myOrientation = 360 + myOrientation%360;
        }
        else if (myOrientation > 360){
            myOrientation = myOrientation%360;
        }
        System.out.println("New orientation is " + myOrientation);
    }
}
