package FrontEnd;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class TurtleView {
    private ImageView turtleImageView;
    private static final String TURTLE_IMAGE = "turtle_green.png";
    private static final int SIZE = 50;
    private Image turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE));
    private Color penColor = Color.BLACK;
    private boolean isPenUp = false;

    public TurtleView(){
        turtleImageView = new ImageView(turtleImage);
        turtleImageView.setFitWidth(SIZE);
        turtleImageView.setFitHeight(SIZE);
    }

    public ImageView getTurtleImageView(){
        return turtleImageView;
    }

    public double getX(){
        return turtleImageView.getLayoutX();
    }

    public double getY(){
        return turtleImageView.getLayoutY();
    }

    // update the position of the turtle
    public void update(double x, double y){
        turtleImageView.setLayoutX(x);
        turtleImageView.setLayoutY(y);
        if(!isPenUp){

        }
    }

    public double getWidth(){
        return turtleImageView.getBoundsInLocal().getWidth();
    }

    public double getHeight(){
        return turtleImageView.getBoundsInLocal().getHeight();
    }

    // turnTurtle the turtle by a certain degree
    public void turn(double degrees){
        turtleImageView.setRotate(turtleImageView.getRotate() + degrees);
    }

    public void setTurtleImage(String fileName){
        turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(fileName));
        turtleImageView.setImage(turtleImage);
    }


}
