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

    // update the position of the turtle
    public void update(double x, double y){
        turtleImageView.setLayoutX(x);
        turtleImageView.setLayoutY(y);
    }

    public void setTurtleImage(String path){
        turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(path));
        turtleImageView.setImage(turtleImage);
    }

    public void leaveTrail(){

    }

}
