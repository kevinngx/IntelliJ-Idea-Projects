package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreenController {

    @FXML
    private GridPane rootPane;

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginConfirmation;

    public void buttonLogin() throws IOException {

        if (userNameField.getText().equals("Pretentious") && passwordField.getText().equals("Hipster")) {
            loginConfirmation.setTextFill(Color.GREEN);
            loginConfirmation.setText("Login Success");
            System.out.println("User has logged in, launching next window");

            // Opening new page
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("MusicListScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Music List Screen");
            stage.setScene(scene);
            stage.show();


        } else {
            loginConfirmation.setTextFill(Color.RED);
            loginConfirmation.setText("Login Unsuccessful, please try again");
            System.out.println("Incorrect Password");
        }

    }

}
