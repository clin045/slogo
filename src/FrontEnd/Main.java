package FrontEnd;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final String TITLE = "SLogo";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = new Group();

        primaryStage.setTitle(TITLE);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }



}
