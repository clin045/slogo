package FrontEnd;

import javafx.application.Platform;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Pair;

import java.io.File;
import java.util.Optional;
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

    public static HBox createTextLabelWithValue(String label, String value){
        Text lab = new Text(label);
        Text val = new Text(value);
        return new HBox(lab, val);
    }

    public static HBox createTextFieldWithLabel(String label, String value, EventHandler<ActionEvent> handler){
        Text lab = new Text(label);
        Button textField = new Button();
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

    public static Point2D createDialogBox(){
        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("TestName");

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 150, 10, 10));

        TextField from = new TextField();
        from.setPromptText("X Position");
        TextField to = new TextField();
        to.setPromptText("Y Position");

        gridPane.add(from, 0, 0);
//        gridPane.add(new Label("To:"), 1, 0);
        gridPane.add(to, 2, 0);

        dialog.getDialogPane().setContent(gridPane);

        // Request focus on the username field by default.
        Platform.runLater(() -> from.requestFocus());

        // Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(from.getText(), to.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        final Point2D[] point2D = new Point2D[1];
        result.ifPresent(pair -> {
            System.out.println("X Position:" + pair.getKey() + "Y Position:" + pair.getValue());
            point2D[0] = new Point2D(Double.parseDouble(pair.getKey()), Double.parseDouble(pair.getValue()));
        });
        return point2D[0];
    }

}
