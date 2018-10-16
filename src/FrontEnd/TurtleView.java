package FrontEnd;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleView {
    private ImageView turtleImageView;
    private static final String TURTLE_IMAGE = "turtle_green.png";
    private static final int SIZE = 50;
    private Image turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE));
    private boolean isPenUp = false;

    public TurtleView(){
        turtleImageView = new ImageView(turtleImage);
        turtleImageView.setFitWidth(SIZE);
        turtleImageView.setFitHeight(SIZE);
    }

    public ImageView getTurtleImageView(){
        return turtleImageView;
    }

    public void update(double x, double y){
        turtleImageView.setLayoutX(x);
        turtleImageView.setLayoutY(y);
    }


}
