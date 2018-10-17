package FrontEnd;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;

/*
    This class represents the view for setting
    @author xp19
 */
public class ControlPanelView {

    private static final String WORKSPACE_SETTING_TITLE = "Workspace Setting";
    private static final String DEFINED_COMMANDS_TITLE = "Defined Commands";
    private static final String DEFINED_VARIABLES_TITLE = "Defined Variables";
    private static final String COMMAND_HISTORY_TITLE = "Command History";
    private static final double VERTICAL_SPACING = 10.0;
    private static final String IMAGE_FILE_EXTENSION = "*.png";

    VBox vBox;
    TitledPane workspaceSetting;
    TitledPane commandHistory;
    TitledPane userDefinedCommands;
    TitledPane definedVariables;
    Controller controller;

    public ControlPanelView(Workspace workspace, Controller controller){
        //using a two-parameter constructor
        setUpWorkspaceSetting();
        setUpCommandHistoryPane();
        this.controller = controller;
        userDefinedCommands = new TitledPane(DEFINED_COMMANDS_TITLE, new VBox());
        definedVariables = new TitledPane(DEFINED_VARIABLES_TITLE, new VBox());
        vBox = new VBox(workspaceSetting, commandHistory, userDefinedCommands, definedVariables);
        workspace.setRight(vBox);
        // add text input field
        workspace.setBottom(new TextArea());
    }

    private void setUpWorkspaceSetting(){
        // add bg color picker
        ColorPicker bgColorPicker = new ColorPicker();
        bgColorPicker.setOnAction(event -> {
            controller.setTurtleDisplayAreaColor(bgColorPicker.getValue());
            controller.update(30,30);
        });
        HBox bgColorBox = UIFactory.createInputFieldWithLabel("Background color: ", bgColorPicker);

        // add pen color picker
        ColorPicker penColorPicker = new ColorPicker();
        penColorPicker.setOnAction(event -> {
            controller.setPenColor(penColorPicker.getValue());
            controller.update(100,100);
        });

        HBox penColorBox = UIFactory.createInputFieldWithLabel("Pen's color: ", penColorPicker);

        // add turtle image setter
        Button button = new Button("Choose..");
        button.setOnAction(event -> {
            FileChooser chooser = UIFactory.createFileChooser(IMAGE_FILE_EXTENSION);
            File file = chooser.showOpenDialog(null);
            controller.setTurtleImage(file.getName());
        });
        HBox imageSetter = UIFactory.createInputFieldWithLabel("Change turtle image: ", button);

        VBox setting = new VBox(bgColorBox, penColorBox, imageSetter);
        setting.setSpacing(VERTICAL_SPACING);
        workspaceSetting = new TitledPane(WORKSPACE_SETTING_TITLE, setting);
    }

    private void setUpCommandHistoryPane(){
        commandHistory = new TitledPane(COMMAND_HISTORY_TITLE, new VBox());
    }


}
