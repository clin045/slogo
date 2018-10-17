package FrontEnd;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

import java.io.File;

/*
    A utility class for creating UI elements
    @author xp19
 */

public class UIFactory {

    public static HBox createInputFieldWithLabel(String label, Node node){
        HBox hBox = new HBox(new Label(label), node);
        hBox.setAlignment(Pos.CENTER_RIGHT);
        return hBox;
    }

    public static FileChooser createFileChooser(String extension){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("Choose an image",extension));
        return fileChooser;
    }

}
