package FrontEnd;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleView {
    private int id; // each turtle view will have to have a unique ID
    private ImageView turtleImageView;
    private static final String TURTLE_IMAGE = "turtle_green.png";
    private static final int SIZE = 50;
    private Image turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE));

    public TurtleView(){
        turtleImageView = new ImageView(turtleImage);
        turtleImageView.setFitWidth(SIZE);
        turtleImageView.setFitHeight(SIZE);
    }

    public ImageView getTurtleImageView(){
        return turtleImageView;
    }

    // gives the x position of the turtle in the playground
    public double getX(){
        return turtleImageView.getLayoutX();
    }

    public double getY(){
        return turtleImageView.getLayoutY();
    }

    // update the position of the turtle to a new position
    public void update(double x, double y){
        turtleImageView.setLayoutX(x);
        turtleImageView.setLayoutY(y);
    }

    public double getWidth(){
        return turtleImageView.getBoundsInLocal().getWidth();
    }

    public double getHeight(){
        return turtleImageView.getBoundsInLocal().getHeight();
    }

    // turn the turtle by a certain degree
    public void turn(double degrees){
        turtleImageView.setRotate(turtleImageView.getRotate() + degrees);
    }

    public void setTurtleImage(String fileName){
        turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(fileName));
        turtleImageView.setImage(turtleImage);
    }

    public void show(){
        turtleImageView.setVisible(true);
    }

    public void hide(){
        turtleImageView.setVisible(false);
    }

}
