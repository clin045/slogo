package FrontEnd;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TurtleDisplayArea extends Pane {

    public TurtleDisplayArea(){
        setBgColor(Color.PINK);
    }

    public void setBgColor(Color color){
        BackgroundFill primaryLayer = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(primaryLayer);
        this.setBackground(background);

    }
}
