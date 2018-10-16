package FrontEnd;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;


public class UIManager {

    StackPane stackPane;
    TitledPane tp;

    public UIManager(Group root, Scene scene){
        WorkspaceManager workspaceManager = new WorkspaceManager(scene);
        stackPane = workspaceManager.getWorkspace();

//        borderPane.setCenter(view.getTurtleImageView());
//        borderPane.setBottom(new TextArea());
//        ControlPanelView controlPanelView = new ControlPanelView();
//        borderPane.setRight(controlPanelView.getSettingMenu());
        root.getChildren().add(stackPane);
    }

}
