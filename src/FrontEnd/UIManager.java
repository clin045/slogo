package FrontEnd;

import javafx.scene.Group;
import javafx.scene.Scene;

public class UIManager {

    public UIManager(Group root, Scene scene){
        WorkspaceManager workspaceManager = new WorkspaceManager(scene);
        root.getChildren().add(workspaceManager.getWorkspace());
    }

}
