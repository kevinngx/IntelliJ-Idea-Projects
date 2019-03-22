import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SwitchingScenes extends Application {

    Stage window;
    Scene sceneOne, sceneTwo;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //Button 1
        Label labelOne = new Label("Welcome to the first scene!");
        Button buttonOne = new Button("Go to scene 2");
        buttonOne.setOnAction(e -> window.setScene(sceneTwo));

        //Layout 1 - children are laid out in a vertical column
        VBox layoutOne = new VBox(20);
        layoutOne.getChildren().addAll(labelOne, buttonOne);
        sceneOne = new Scene(layoutOne, 200, 200);

        //Button 2
        Button buttonTwo = new Button("Go back to scene 1");
        buttonTwo.setOnAction(e -> window.setScene(sceneOne));

        //Layout 2
        StackPane layoutTwo = new StackPane();
        layoutTwo.getChildren().add(buttonTwo);
        sceneTwo = new Scene(layoutTwo, 200, 200);

        window.setScene(sceneOne);
        window.show();
    }


}
