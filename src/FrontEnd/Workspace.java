package FrontEnd;

/*
    Represents individual tab and all UI elements contained in it
    @author xp19
 */

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Workspace extends BorderPane {

    public Workspace(){
        ControlPanelView controlPanelView = new ControlPanelView(this);
        TurtleDisplayArea area = new TurtleDisplayArea();
        TurtleView view = new TurtleView();
        area.getChildren().add(view.getTurtleImageView());
        this.setCenter(area);
        view.update(area.getBoundsInLocal().getWidth()/2, area.getBoundsInLocal().getHeight()/2);
//        this.setRight(controlPanelView.getSettingMenu());
    }
}
