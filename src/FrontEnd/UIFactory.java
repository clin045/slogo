package FrontEnd;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;

/*
    A utility class for creating JavaFX UI elements including HBox, Button and FileChooser
    @author xp19
 */

public class UIFactory {

    public static HBox createInputFieldWithLabel(String label, Node node){
        HBox hBox = new HBox(new Label(label), node);
        hBox.setAlignment(Pos.CENTER_RIGHT);
        return hBox;
    }

    public static Button createButton(String text, EventHandler<ActionEvent> handler){
        Button button = new Button(text);
        button.setOnAction(handler);
        return button;
    }

    public static Text createText(String text){
        return new Text(text);
    }

    public static FileChooser createFileChooser(String extension){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("Choose an image",extension));
        return fileChooser;
    }

}
