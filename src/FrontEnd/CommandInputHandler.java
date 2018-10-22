package FrontEnd;

import Backend.Command;
import Backend.CommandManager;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;


public class CommandInputHandler extends TextArea {

    private Controller controller;
    private String language = "English"; // default language
    private CommandManager commandManager;
    private TitledPane variableHistory;
    private TitledPane commandHistory;
    private int keySize = 0;

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

        if(keySize!=CommandManager.myTracker.keySet().size()){
            VBox definedVariable = (VBox) variableHistory.getContent();
//            String lastKey = new String();
//            Iterator<String> itr = CommandManager.myTracker.keySet().iterator();
//            while(itr.hasNext()) {
//                System.out.println(itr.next());
//                lastKey = itr.next();
//            }
            String lastKey = getLastKey(CommandManager.myTracker.keySet());
            System.out.println("Last key:" + lastKey);
            definedVariable.getChildren().add(UIFactory.createText(lastKey + ": " + CommandManager.myTracker.get(lastKey)));
            keySize = CommandManager.myTracker.keySet().size();
        }

        return this.getText();
    }

    private String getLastKey(Set<String> set){
//        Collections.sort(set);
        int index = 0;
        for(String s: set){
            System.out.println("Index:"+s);
            if(index==set.size()-1){
                return s;
            }
            index++;
        }
        return new String();
    }

    private void showWarningDialog(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @Override
    public void replaceText(int start, int end, String text) {
        String current = getText();
        // only insert if no new lines after insert position:
        if (! current.substring(start).contains("\n")) {
            super.replaceText(start, end, text);
        }
    }
    @Override
    public void replaceSelection(String text) {
        String current = getText();
        int selectionStart = getSelection().getStart();
        if (! current.substring(selectionStart).contains("\n")) {
            super.replaceSelection(text);
        }
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
