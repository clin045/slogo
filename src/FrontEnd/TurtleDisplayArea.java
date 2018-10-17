package FrontEnd;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/*
    Represents the area where turtle moves
    @author xp19
 */

public class TurtleDisplayArea extends Pane {

    public TurtleDisplayArea(TurtleView turtleView){
        setBgColor(Color.WHITE);
        addTurtle(turtleView.getTurtleImageView());
    }

    // set the background color of this pane
    public void setBgColor(Color color){
        BackgroundFill primaryLayer = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(primaryLayer);
        this.setBackground(background);
    }

    // put an additional turtle to the center of pane
    private void addTurtle(Node element){
        this.getChildren().add(element);
        this.widthProperty().addListener(e -> element.setLayoutX(this.getWidth() / 2.0));
        this.heightProperty().addListener(e -> element.setLayoutY(this.getHeight() / 2.0));
    }
}
