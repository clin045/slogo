package FrontEnd;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;


public class UIManager {

    StackPane stackPane;

    public UIManager(Group root, Scene scene){
        WorkspaceManager workspaceManager = new WorkspaceManager(scene);
        stackPane = workspaceManager.getWorkspace();

        root.getChildren().add(stackPane);
    }



}
