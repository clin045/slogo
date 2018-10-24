package FrontEnd;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;

import static FrontEnd.TurtlePlayground.INIT_STROKE_WIDTH;

/*
    This class represents the view for setting
    @author xp19
 */
public class ControlPanelView {

    private static final String WORKSPACE_SETTING_TITLE = "Workspace Setting";
    private static final String DEFINED_COMMANDS_TITLE = "Defined Commands";
    private static final String DEFINED_VARIABLES_TITLE = "Defined Variables";
    private static final String COMMAND_HISTORY_TITLE = "Command History";
    private static final String TURTLE_STATUS_TITLE = "Turtle Status";
    private static final double VERTICAL_SPACING = 10.0;
    private static final String IMAGE_FILE_EXTENSION = "*.png";

    VBox vBox;
    Workspace workspace;
    TitledPane workspaceSetting;
    TitledPane commandHistory;
    TitledPane userDefinedCommands;
    TitledPane definedVariables;
    TitledPane turtleStatus;
    Controller controller;
    CommandInputHandler commandInputHandler;

    public ControlPanelView(Workspace workspace, Controller controller){
        this.workspace = workspace;
        this.controller = controller;
        //set up UI
        setUpTextInputArea(workspace);// add text input field
        setUpWorkspaceSetting();
        setUpCommandHistoryPane();
        setUpTurtleStatus();
        userDefinedCommands = new TitledPane(DEFINED_COMMANDS_TITLE, new VBox());
        definedVariables = new TitledPane(DEFINED_VARIABLES_TITLE, new VBox());
        vBox = new VBox(workspaceSetting, commandHistory, userDefinedCommands, definedVariables);
        workspace.setRight(vBox);
    }

    public CommandInputHandler getCommandInputHandler(){
        return commandInputHandler;
    }

    private void setUpWorkspaceSetting(){
        // add bg color picker
        ColorPicker bgColorPicker = new ColorPicker();
        bgColorPicker.setOnAction(event -> {
            controller.setTurtleDisplayAreaColor(bgColorPicker.getValue());
//            controller.reset();
        });
        HBox bgColorBox = UIFactory.createInputFieldWithLabel("Background color: ", bgColorPicker);

        // add pen color picker
        ColorPicker penColorPicker = new ColorPicker(Color.BLACK);
        penColorPicker.setOnAction(event -> {
            controller.setPenColor(penColorPicker.getValue());
        });

        HBox penColorBox = UIFactory.createInputFieldWithLabel("Pen's color: ", penColorPicker);

        // add pen up/down
        final ToggleGroup group = new ToggleGroup();

        ToggleButton tb1 = new ToggleButton("Up");
        tb1.setToggleGroup(group);
        ToggleButton tb2 = new ToggleButton("Down");
        tb2.setToggleGroup(group);
        tb2.setSelected(true);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                controller.togglePenDown();
            }
        });

        HBox upDown = new HBox(tb1, tb2);
        upDown.setAlignment(Pos.CENTER_RIGHT);

        // add pen thickness
        Text label = UIFactory.createText("Pen Thickness: ");
        TextField textField = new TextField(String.valueOf(TurtlePlayground.INIT_STROKE_WIDTH));
        textField.setOnAction(event -> {
            controller.setPenThickness(Double.parseDouble(textField.getText()));
        });
        HBox penThicknessBox = UIFactory.createInputFieldWithLabel("Pen Thickness: ", textField);
//
//        HBox penThick = UIFactory.createTextFieldWithLabel("Pen Thickness: ", String.valueOf(TurtlePlayground.INIT_STROKE_WIDTH), event -> {
//            controller.setPenThickness();
//                });


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
        VBox setting = new VBox(bgColorBox, penColorBox,  upDown, penThicknessBox, imageSetter, languageSetter);
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
        Button newTabButton = UIFactory.createButton("New Tab", event -> {
            addNewTab();
        });
        Button loadButton = UIFactory.createButton("Load", event -> {
           // load file
        });

        Button saveButton = UIFactory.createButton("Save", event -> {
            // save file
        });

        HBox buttonsGroup = new HBox(runButton, clearHistoryButton, newTabButton, loadButton, saveButton);
        VBox textInput= new VBox(buttonsGroup, commandInputHandler);
        workspace.setBottom(textInput);
    }

    private void setUpCommandHistoryPane(){
        commandHistory = new TitledPane(COMMAND_HISTORY_TITLE, new VBox());
    }

    private void setUpTurtleStatus(){
        turtleStatus = new TitledPane(TURTLE_STATUS_TITLE, new VBox());
    }

    private void clearCommandHistory(){
        VBox history = ((VBox) commandHistory.getContent());
        history.getChildren().clear();
    }

    private void addNewTab(){
        Tab newTab = new Tab("New Tab");
        newTab.setContent(new Workspace(workspace.tabPane));
        workspace.tabPane.getTabs().add(newTab);
    }

    public VBox getRightMenu(){
        return vBox;
    }
}
