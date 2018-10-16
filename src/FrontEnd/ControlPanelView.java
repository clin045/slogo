package FrontEnd;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/*
    This class represents the view for setting
    @author xp19
 */
public class ControlPanelView {

    private static final String WORKSPACE_SETTING_TITLE = "Workspace Setting";
    private static final double VERTICAL_SPACING = 10.0;

    VBox vBox;
    TitledPane workspaceSetting;
    TitledPane commandHistory;
    TitledPane userDefinedCommands;
    TitledPane definedVariables;

    public ControlPanelView(Workspace workspace){
        //using a two-parameter constructor
        setUpWorkspaceSetting();
        setUpCommandHistoryPane();
        userDefinedCommands = new TitledPane("Defined commands", new VBox());
        definedVariables = new TitledPane("Defined variables", new VBox());
        vBox = new VBox(workspaceSetting, commandHistory, userDefinedCommands, definedVariables);
        workspace.setRight(vBox);
    }



    private void setUpWorkspaceSetting(){
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction((EventHandler) t -> {
            Color c = colorPicker.getValue();
            System.out.println("New Color's RGB = "+c.getRed()+" "+c.getGreen()+" "+c.getBlue());
        });
        HBox bgColorBox = UIFactory.createInputFieldWithLabel("Background color: ", colorPicker);

        ColorPicker colorPicker1 = new ColorPicker();
        colorPicker1.setOnAction((EventHandler) t -> {
            Color c = colorPicker.getValue();
            System.out.println("New Color's RGB = "+c.getRed()+" "+c.getGreen()+" "+c.getBlue());
        });

        HBox penColorBox = UIFactory.createInputFieldWithLabel("Pen's color: ", colorPicker1);

        VBox setting = new VBox(bgColorBox, penColorBox);
        setting.setSpacing(VERTICAL_SPACING);
        workspaceSetting = new TitledPane(WORKSPACE_SETTING_TITLE, setting);
    }

    private void setUpCommandHistoryPane(){
        commandHistory = new TitledPane("Command History", new Button("Button"));
//        commandHistory.set
    }


}
