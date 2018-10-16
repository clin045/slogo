package FrontEnd;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;

public class WorkspaceManager {

    StackPane stackPane;
    Workspace workspace;
    TabPane tabPane;

    public WorkspaceManager(Scene scene){
        tabPane = new TabPane();
        workspace = new Workspace();
        Tab tab = new Tab();
        tab.setText("Tab" + 0);
        tab.setContent(workspace);
        tabPane.getTabs().add(tab);

        stackPane = new StackPane();
        stackPane.getChildren().add(tabPane);


        // bind to take available space
        stackPane.prefHeightProperty().bind(scene.heightProperty());
        stackPane.prefWidthProperty().bind(scene.widthProperty());
    }

    StackPane getWorkspace(){
        return stackPane;
    }

}
