package Login;

//TODO: Add Import Statements
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.PageSwitcherHelper;

import java.io.IOException;

public class LoginScreenController {

    enum Login_Status {
        EMPTY_USERNAME, EMPTY_PASSWORD, USER_NOT_FOUND, INCORRECT_PASSWORD, LOGIN_SUCCESSFUL
    }

    // Instantiate the PageSwitchHelper class
    PageSwitcherHelper pageSwitcherHelper = new PageSwitcherHelper();

    @FXML
    TextField input_username;

    @FXML
    PasswordField input_password;

    @FXML
    Label loginStatusLabel;


    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException {

        // Getting login inputs
        String inputUsername = input_username.getText();
        String inputPassword = input_password.getText();

        // Logging
        System.out.println("Username inputted: " + inputUsername);
        System.out.println("Password inputted: " + inputPassword);

        if (inputUsername.isEmpty()) {
            updateLabel(Login_Status.EMPTY_USERNAME);
            return;
        }

        if (inputPassword.isEmpty()) {
            updateLabel(Login_Status.EMPTY_PASSWORD);
            return;
        }

        Login loginAttempt = new Login();
        System.out.println("Finding user...");
        if (loginAttempt.findUser(inputUsername)) {
            System.out.println("User found, authenticating user...");

            if (loginAttempt.authenticateUser(inputPassword)) {
                System.out.println("User authenticated, signing in...");
                updateLabel(Login_Status.LOGIN_SUCCESSFUL);
                pageSwitcherHelper.switcher(event, "MusicList.fxml");
            } else {
                System.out.println("Incorrect Password");
                updateLabel(Login_Status.INCORRECT_PASSWORD);
            }

        } else {
            System.out.println("No user found");
            updateLabel(Login_Status.USER_NOT_FOUND);
        }

    }

    @FXML
    private void handleSignUpButtonAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() {
        //TODO: What should the screen look like when it loads?
    }

    private void updateLabel(Login_Status loginStatus) {
        switch (loginStatus) {

            case EMPTY_USERNAME:
                loginStatusLabel.setTextFill(Color.BLACK);
                loginStatusLabel.setText("Please enter a username");
                break;

            case EMPTY_PASSWORD:
                loginStatusLabel.setTextFill(Color.BLACK);
                loginStatusLabel.setText("Please enter a password");
                break;

            case USER_NOT_FOUND:
                loginStatusLabel.setTextFill(Color.RED);
                loginStatusLabel.setText("User not found");
                break;

            case INCORRECT_PASSWORD:
                loginStatusLabel.setTextFill(Color.RED);
                loginStatusLabel.setText("Incorrect password");
                break;

            case LOGIN_SUCCESSFUL:
                loginStatusLabel.setTextFill(Color.GREEN);
                loginStatusLabel.setText("Login Successful, signing in");
                break;
        }
    }

}
