package FrontEnd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
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
    CommandInputHandler commandInputHandler;

    public ControlPanelView(Workspace workspace, Controller controller){
        this.controller = controller;
        //set up UI
        setUpTextInputArea(workspace);// add text input field
        setUpWorkspaceSetting();
        setUpCommandHistoryPane();
        userDefinedCommands = new TitledPane(DEFINED_COMMANDS_TITLE, new VBox());
        definedVariables = new TitledPane(DEFINED_VARIABLES_TITLE, new VBox());
        vBox = new VBox(workspaceSetting, commandHistory, userDefinedCommands, definedVariables);
        workspace.setRight(vBox);
    }

    private void setUpWorkspaceSetting(){
        // add bg color picker
        ColorPicker bgColorPicker = new ColorPicker();
        bgColorPicker.setOnAction(event -> {
            controller.setTurtleDisplayAreaColor(bgColorPicker.getValue());
//            controller.turnTurtle(60);
//            controller.update(30,30);
        });
        HBox bgColorBox = UIFactory.createInputFieldWithLabel("Background color: ", bgColorPicker);

        // add pen color picker
        ColorPicker penColorPicker = new ColorPicker();
        penColorPicker.setOnAction(event -> {
            controller.setPenColor(penColorPicker.getValue());
//            controller.update(100,100);
        });

        HBox penColorBox = UIFactory.createInputFieldWithLabel("Pen's color: ", penColorPicker);

        // add turtle image setter
        Button button = UIFactory.createButton("Choose..", event -> {
            FileChooser chooser = UIFactory.createFileChooser(IMAGE_FILE_EXTENSION);
            File file = chooser.showOpenDialog(null);
            if(file!=null){
                controller.setTurtleImage(file.getName());
            }
        });
        HBox imageSetter = UIFactory.createInputFieldWithLabel("Change turtle image: ", button);

        // add language setting
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "English", "Chinese", "French", "German",
                        "Italian", "Portuguese", "Russian", "Spanish"
                );
        final ComboBox comboBox = new ComboBox(options);
        comboBox.getSelectionModel().selectFirst();
        comboBox.setOnAction(event -> {
            String s = comboBox.getSelectionModel().getSelectedItem().toString();
            commandInputHandler.setLanguage(s);
        });
        HBox languageSetter = UIFactory.createInputFieldWithLabel("Language: ", comboBox);

        // put everything inside a vbox
        VBox setting = new VBox(bgColorBox, penColorBox, imageSetter, languageSetter);
        setting.setSpacing(VERTICAL_SPACING);
        workspaceSetting = new TitledPane(WORKSPACE_SETTING_TITLE, setting);
    }

    // add text input field and related buttons
    private void setUpTextInputArea(Workspace workspace){
        commandInputHandler = new CommandInputHandler(controller);
        Button runButton = UIFactory.createButton("Run", event -> {
            String command = commandInputHandler.run();
            VBox history = ((VBox) commandHistory.getContent());
            history.getChildren().add(UIFactory.createText(command));
        });
        Button clearHistoryButton = UIFactory.createButton("Clear History", event -> clearCommandHistory());

        HBox buttonsGroup = new HBox(runButton, clearHistoryButton);
        VBox textInput= new VBox(buttonsGroup, commandInputHandler);
        workspace.setBottom(textInput);
    }

    private void setUpCommandHistoryPane(){
        commandHistory = new TitledPane(COMMAND_HISTORY_TITLE, new VBox());
    }

    private void clearCommandHistory(){
        VBox history = ((VBox) commandHistory.getContent());
        history.getChildren().clear();
    }

}
