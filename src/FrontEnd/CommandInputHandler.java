package FrontEnd;

import Backend.CommandManager;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

import java.util.List;


public class CommandInputHandler extends TextArea {

    private Controller controller;
    private String language = "English"; // default language
    private CommandManager commandManager;
    private TitledPane variableHistory;
    private TitledPane commandHistory;
    private TitledPane userDefinedCommands;
    private boolean first = true;

    public CommandInputHandler(Controller controller){
        this.controller = controller;
    }

    /*
        this method will be executed when users press run button,
        do all the text parsing and error handling here
     */
    public String run(){
        if(commandManager==null){
            System.out.println("CommandManager has not been set yet");
        }
        try{
            commandManager.execute(this.getText());
        }
        catch(IllegalArgumentException e){
            showWarningDialog("Error", "Illegal argument error", e.getMessage());
        }

        if(first){
            ObservableMap<String, Object> varMap = CommandManager.myTracker.getVarMap();
            VBox definedVariable = (VBox) variableHistory.getContent();
            ObservableMap<String, List<String>> commandMap = CommandManager.myTracker.getCommandMap();
            ScrollPane definedCommandsScrollPane = (ScrollPane) userDefinedCommands.getContent();
            VBox definedCommands = (VBox) definedCommandsScrollPane.getContent();

            varMap.addListener(new MapChangeListener<String, Object>() {
                @Override
                public void onChanged(Change<? extends String, ?> change) {
                    if(change.wasAdded()){
                        definedVariable.getChildren().add(
                                UIFactory.createTextFieldWithLabel(change.getKey(), varMap.get(change.getKey()).toString(), CommandManager.myTracker.getVarMap()
                        ));
                    }
                }
            });

            for(String s: varMap.keySet()){
                definedVariable.getChildren().add(
                        UIFactory.createTextFieldWithLabel(s, varMap.get(s).toString(), CommandManager.myTracker.getVarMap())
                );
            }

            commandMap.addListener(new MapChangeListener<String, Object>() {
                @Override
                public void onChanged(Change<? extends String, ?> change) {
                    if(change.wasAdded()){
                        definedCommands.getChildren().add(
                                UIFactory.createTextFieldWithLabel(change.getKey(), commandMap.get(change.getKey()).toString(), event -> {
                                    System.out.println(commandMap.get(change.getKey()).toString());
                                    commandManager.execute(commandMap.get(change.getKey()).toString());
                                        }
                                ));
                    }
                }
            });

            for(String s: commandMap.keySet()){
                definedCommands.getChildren().add(
                        UIFactory.createTextFieldWithLabel(s, commandMap.get(s).toString(), event -> {
                            commandManager.execute(commandMap.get(s).toString());
                        })
                );
            }


            first = false;
        }

        return this.getText();
    }

    private void showWarningDialog(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }


    public void setLanguage(String lan){
        this.language = lan;
        commandManager.setLanguage("Languages."+lan);
    }

    public void setCommandManager(CommandManager manager){
        this.commandManager = manager;
    }

    public void setVariableHistory(TitledPane variableHistory) {
        this.variableHistory = variableHistory;
    }

    public void setCommandHistory(TitledPane commandHistory) {
        this.commandHistory = commandHistory;
    }

    public void setUserDefinedCommands(TitledPane userDefinedCommands){
        this.userDefinedCommands = userDefinedCommands;
    }
}
