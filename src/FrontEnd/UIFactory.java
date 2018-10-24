package FrontEnd;

import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

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
        Text ret = new Text(text);
        ret.setWrappingWidth(250);
        return ret;
    }

    public static HBox createTextFieldWithLabel(String label, String value, EventHandler<ActionEvent> handler){
        Text lab = new Text(label);
        TextField textField = new TextField();
        textField.setText(value);
        textField.setOnAction(handler);
        HBox ret = new HBox(lab, textField);
        ret.setAlignment(Pos.CENTER);
        return ret;
    }

    public static HBox createTextFieldWithLabel(String label, String value, ObservableMap<String, Object> map){
        Text lab = new Text(label);
        TextField textField = new TextField();
        textField.setText(value);
        textField.setOnAction(event -> {
            map.put(label, textField.getText());
            System.out.println(textField.getText());
        });
        HBox ret = new HBox(lab, textField);
        ret.setAlignment(Pos.CENTER);
        return ret;
    }


    // create a file chooser which starts from the project's root directory
    public static FileChooser createFileChooser(String extension){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("Choose an image",extension));
        return fileChooser;
    }

}
