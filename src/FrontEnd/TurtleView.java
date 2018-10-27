package FrontEnd;

import Backend.Turtle;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.event.EventHandler;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class TurtleView {
    private int id; // each turtle view will have to have a unique ID
    private ImageView turtleImageView;
    private static final String TURTLE_IMAGE = "turtle_green.png";
    private static final int SIZE = 50;
    private static double heading = 90;
    private boolean isActive;
    private Image turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE));

    public TurtleView(){
        turtleImageView = new ImageView(turtleImage);
        turtleImageView.setFitWidth(SIZE);
        turtleImageView.setFitHeight(SIZE);
        turtleImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ColorAdjust colorAdjustGrayscale = new ColorAdjust();
                colorAdjustGrayscale.setSaturation(-1);
                turtleImageView.setEffect(colorAdjustGrayscale);
                turtleImageView.setEffect(null);
                System.out.println("Clicked");
            }
        });
    }

    public TurtleView(int id){
        this();
        this.id = id;
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
        turtleImageView.setLayoutX(getX()+x);
        turtleImageView.setLayoutY(getY()-y);
    }

    public double getWidth(){
        return turtleImageView.getBoundsInLocal().getWidth();
    }

    public double getHeight(){
        return turtleImageView.getBoundsInLocal().getHeight();
    }


    public void rotate(double newHeading){
//        turtleImageView.setRotate(turtleImageView.getRotate()-(newHeading-heading));
        RotateTransition rt = new RotateTransition(Duration.seconds(2));
//        rt.setToAngle(90);
        rt.setByAngle(heading-newHeading);
        // put them together in order
        Animation animation = new SequentialTransition(turtleImageView, rt);
        animation.play();
        heading = newHeading;
    }

    public void setTurtleImage(String fileName){
        turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(fileName));
        turtleImageView.setImage(turtleImage);
    }

    public void resetTurtleHeading(){
        turtleImageView.setRotate(0);
        heading = Turtle.DEFAULT_HEADING;
    }

    public void show(){
        turtleImageView.setVisible(true);
    }

    public void hide(){
        turtleImageView.setVisible(false);
    }



}
