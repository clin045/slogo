package FrontEnd;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;

public class UIManager {

    BorderPane borderPane;
    TitledPane tp;

    public UIManager(Group root, Scene scene){
        WorkspaceManager workspaceManager = new WorkspaceManager(scene);
        borderPane = workspaceManager.getWorkspace();
        TurtleView view = new TurtleView();
        borderPane.setCenter(view.getTurtleImageView());
        borderPane.setBottom(new TextArea());
        ControlPanelView controlPanelView = new ControlPanelView();
        borderPane.setRight(controlPanelView.getSettingMenu());
        root.getChildren().add(borderPane);
    }

}
