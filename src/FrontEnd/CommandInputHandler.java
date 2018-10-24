package FrontEnd;

import Backend.Command;
import Backend.CommandManager;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

import java.util.HashMap;


public class CommandInputHandler extends TextArea {

    private Controller controller;
    private String language = "English"; // default language
    private CommandManager commandManager;
    private TitledPane variableHistory;
    private TitledPane commandHistory;
    private HashMap<String, Object> variables;
    private HashMap<String, Object> commands;
//    private ObservableMap<String, Object> observableMap;
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
            ObservableMap<String, Object> map = CommandManager.myTracker.getVarMap();
            VBox definedVariable = (VBox) variableHistory.getContent();

            map.addListener(new MapChangeListener<String, Object>() {
                @Override
                public void onChanged(Change<? extends String, ?> change) {
                    if(!map.containsKey(change.getKey())){
                        definedVariable.getChildren().add(UIFactory.createText(change.getKey()+": "+change.getValueAdded()));
                    }
                }
            });

            for(String s: map.keySet()){
                definedVariable.getChildren().add(
                        UIFactory.createTextFieldWithLabel(s, map.get(s).toString(), CommandManager.myTracker.getVarMap())
                );
//                definedVariable.getChildren().add(UIFactory.createText(s+": "+map.get(s)));
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
}
