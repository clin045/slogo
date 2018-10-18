package FrontEnd;

/*
    Represents the content inside each individual tab (all UI elements contained in it)
    @author xp19
 */

import javafx.scene.layout.BorderPane;

public class Workspace extends BorderPane {

    TurtlePlayground area;
    TurtleView view;

    // create a new workspace
    public Workspace(){
        setUpTurtleDisplayArea();
        Controller controller = new Controller(area, view);
        ControlPanelView controlPanelView = new ControlPanelView(this, controller);
    }

    // initialize the display area in the border pane
    private void setUpTurtleDisplayArea(){
        view = new TurtleView();
        area = new TurtlePlayground(view);
        this.setCenter(area);
    }

}
