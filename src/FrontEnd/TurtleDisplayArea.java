package FrontEnd;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
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
