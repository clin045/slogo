package FrontEnd;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

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

    public static FileChooser createFileChooser(){
        return new FileChooser();

    }

}
