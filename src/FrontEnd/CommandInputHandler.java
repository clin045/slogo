package FrontEnd;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;


public class CommandInputHandler extends TextArea {

    Controller controller;
    String language = "English";

    public CommandInputHandler(Controller controller){
        this.controller = controller;
    }

    /*
        this method will be executed when users press run button,
        do all the text parsing and error handling here
     */
    public void run(){
        System.out.println(this.getText());
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
    }

}
