package FrontEnd;

import Backend.CommandManager;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;


public class CommandInputHandler extends TextArea {

    private Controller controller;
    private String language = "English"; // default language
    private CommandManager commandManager;

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



        return this.getText();
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

}
