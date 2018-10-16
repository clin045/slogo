package FrontEnd;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application{

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final String TITLE = "SLogo";

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle(TITLE);
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT, Color.AZURE);

        UIManager uiManager = new UIManager(root, scene);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
