package FrontEnd;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
    private static final String TURTLE_STATUS_TITLE = "Turtle Status";
    private static final double VERTICAL_SPACING = 10.0;
    private static final String IMAGE_FILE_EXTENSION = "*.png";
    private static final String DEFAULT_HEADING = "90";
    private static final String DEFAULT_POSITION = "0,0";
    private static final String DEFAULT_ID = "0";

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
        commandHistory = setUpScrollingTitlePane(COMMAND_HISTORY_TITLE, commandHistory);
        setUpTurtleStatus();
        userDefinedCommands = setUpScrollingTitlePane(DEFINED_COMMANDS_TITLE, userDefinedCommands);
        definedVariables = new TitledPane(DEFINED_VARIABLES_TITLE, new VBox());
        vBox = new VBox(workspaceSetting, commandHistory, userDefinedCommands, definedVariables, turtleStatus);
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
        });
        HBox bgColorBox = UIFactory.createInputFieldWithLabel("Background color: ", bgColorPicker);

        // add pen color picker
        ColorPicker penColorPicker = new ColorPicker(Color.BLACK);
        penColorPicker.setOnAction(event -> {
            controller.setPenColor(penColorPicker.getValue());
        });

        HBox penColorBox = UIFactory.createInputFieldWithLabel("Pen's color: ", penColorPicker);

        // add pen down button
        HBox upDown = addPenDownButton();
        upDown.setAlignment(Pos.CENTER_RIGHT);

        // add pen thickness
        TextField textField = new TextField(String.valueOf(TurtlePlayground.INIT_STROKE_WIDTH));
        textField.setOnAction(event -> {
            controller.setPenThickness(Double.parseDouble(textField.getText()));
        });
        HBox penThicknessBox = UIFactory.createInputFieldWithLabel("Pen Thickness: ", textField);

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
        HBox languageSetter = UIFactory.createInputFieldWithLabel("Language: ", addLanguageComboBox());

        // put everything inside a vbox
        VBox setting = new VBox(bgColorBox, penColorBox,  upDown, penThicknessBox, imageSetter, languageSetter);
        setting.setSpacing(VERTICAL_SPACING);
        workspaceSetting = new TitledPane(WORKSPACE_SETTING_TITLE, setting);
    }

    private HBox addPenDownButton(){
        final ToggleGroup group = new ToggleGroup();

        ToggleButton tb2 = new ToggleButton("Down");
        tb2.setToggleGroup(group);
        tb2.setSelected(true);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                controller.togglePenDown();
            }
        });
        return new HBox(tb2);
    }

    private ComboBox addLanguageComboBox(){
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "English", "Chinese", "French", "German",
                        "Italian", "Portuguese", "Russian", "Spanish"
                );
        ComboBox comboBox = new ComboBox(options);
        comboBox.getSelectionModel().selectFirst();
        comboBox.setOnAction(event -> {
            String s = comboBox.getSelectionModel().getSelectedItem().toString();
            commandInputHandler.setLanguage(s);
        });
        return comboBox;
    }

    // add text input field and related buttons
    private void setUpTextInputArea(Workspace workspace){
        commandInputHandler = new CommandInputHandler(controller);
        Button runButton = UIFactory.createButton("Run", event -> {
            String command = commandInputHandler.run();
            VBox history = (VBox)((ScrollPane) commandHistory.getContent()).getContent();
            history.getChildren().add(UIFactory.createText(command));
        });
        Button clearHistoryButton = UIFactory.createButton("Clear History", event -> clearCommandHistory());
        Button newTabButton = UIFactory.createButton("New Tab", event -> {
            addNewTab();
        });
        Button loadButton = UIFactory.createButton("Load", event -> {
           // load file here
        });

        Button saveButton = UIFactory.createButton("Save", event -> {
            // save file here
        });

        HBox buttonsGroup = new HBox(runButton, clearHistoryButton, newTabButton, loadButton, saveButton);
        VBox textInput= new VBox(buttonsGroup, commandInputHandler);
        workspace.setBottom(textInput);
    }

    private TitledPane setUpScrollingTitlePane(String title, TitledPane titledPane){
        VBox allCommands = new VBox();
        ScrollPane sp = new ScrollPane();
        sp.setContent(allCommands);
        titledPane = new TitledPane(title, sp);
        sp.setPadding(new Insets(Workspace.PADDING));
        titledPane.setExpanded(false);
        return titledPane;
    }

    private void setUpTurtleStatus(){
        HBox ID = UIFactory.createTextLabelWithValue("ID: ", DEFAULT_ID);
        HBox position = UIFactory.createTextLabelWithValue("Position: ", DEFAULT_POSITION);
        HBox heading = UIFactory.createTextLabelWithValue("Heading: ", DEFAULT_HEADING);
        turtleStatus = new TitledPane(TURTLE_STATUS_TITLE, new VBox(ID, position, heading));
    }

    private void clearCommandHistory(){
        VBox history = (VBox) ((ScrollPane) commandHistory.getContent()).getContent();
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
