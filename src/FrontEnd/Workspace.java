package FrontEnd;

/*
    Represents individual tab and all UI elements contained in it
    @author xp19
 */

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Workspace extends BorderPane {

    public Workspace(){
        ControlPanelView controlPanelView = new ControlPanelView(this);
        TurtleDisplayArea area = new TurtleDisplayArea();
        area.setMaxSize(800,800);
        TurtleView view = new TurtleView();
        ImageView element = view.getTurtleImageView();
        area.getChildren().add(view.getTurtleImageView());
        this.setCenter(area);
//        area.setAlignment(Pos.CENTER);
//        area.setAlignment(Pos.);


//        view.setLayoutX(myDisplayArea.getWidth() / 2.0);
//        element.setLayoutY(myDisplayArea.getHeight() / 2.0);
        area.widthProperty().addListener(e -> {
            element.setLayoutX(area.getWidth() / 2.0);
        });
        area.heightProperty().addListener(e -> {
            element.setLayoutY(area.getHeight() / 2.0);
        });

//        view.getTurtleImageView().translateXProperty().bind(widthProperty().divide(2));
//        view.getTurtleImageView().translateYProperty().bind(heightProperty().divide(2));
//        System.out.println(area.getBoundsInLocal().getWidth()+":"+area.getBoundsInLocal().getHeight()/2);
//        view.update(area.getBoundsInLocal().getWidth()/2, area.getBoundsInLocal().getHeight()/2);
//        this.setRight(controlPanelView.getSettingMenu());
    }
}
