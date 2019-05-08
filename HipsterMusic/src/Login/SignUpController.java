package Login;

import Login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import sample.Database;
import sample.User;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpController {

    // Instantiate the database class
    Database database = new Database();

    @FXML
    TextField input_username;

    @FXML
    PasswordField input_passwordOne;

    @FXML
    PasswordField input_passwordTwo;

    @FXML
    Label signupStatusLabel;

    @FXML
    private void handleSignUpButtonAction(ActionEvent event) throws IOException {

        // Getting signup inputs
        String inputUsername = input_username.getText();
        String inputPasswordOne = input_passwordOne.getText();
        String inputPasswordTwo = input_passwordTwo.getText();

        // Check that all fields are filled in
        if (inputUsername.isEmpty() || inputPasswordOne.isEmpty() || inputPasswordTwo.isEmpty()) {
            signupStatusLabel.setTextFill(Color.RED);
            signupStatusLabel.setText("Please fill out all fields");
            return;
        }

        // Check if the passwords are the same
        if (!inputPasswordOne.equals(inputPasswordTwo)) {
            signupStatusLabel.setTextFill(Color.RED);
            signupStatusLabel.setText("Passwords do not match");
            return;
        }

        // Check if username is taken
        if (!checkUniqueUsername(inputUsername)) {
            signupStatusLabel.setTextFill(Color.RED);
            signupStatusLabel.setText("Username already taken, please try another one");
            return;
        }

        // Create user object
        User newUser = new User(inputUsername, inputPasswordOne);

        createNewUser(newUser);

        // Success Message
        signupStatusLabel.setTextFill(Color.GREEN);
        signupStatusLabel.setText("Sign up successful! Please close this window");
        System.out.println("Username inputted: " + inputUsername);
        System.out.println("PasswordOne inputted: " + inputPasswordOne);
        System.out.println("PasswordTwo inputted: " + inputPasswordTwo);

    }

    private boolean checkUniqueUsername(String inputUsername) {
        Login loginAttempt = new Login();
        System.out.println("Username exists: " + loginAttempt.findUser(inputUsername));
        if (loginAttempt.findUser(inputUsername)) {
            return false;
        } else {
            return true;
        }
    }

    private void createNewUser(User newUser) {

        String query = String.format("INSERT INTO Login \n" +
                "(USERNAME, PASSWORD)\n" +
                "VALUES (\"%s\" , \"%s\" );", newUser.getUsername(), newUser.getPassword());

        System.out.println("Result Query = " + query);

        try {
            database.insertStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
