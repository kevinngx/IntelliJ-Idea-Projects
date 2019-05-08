package Login;

import sample.Database;

import java.sql.ResultSet;

public class Login {
    private int id;
    private String username;
    private String password;
    Database database = new Database();

    public boolean findUser(String username) {
        String query = "SELECT * FROM Login \n" +
                        "WHERE USERNAME = \"" + username + "\"";

        //TODO: Get the username and password from the GUI
        boolean userFound = false;
        try {
            ResultSet rs = database.getResultSet(query);
            if (rs.next()) {
                // Logging result
                this.id = Integer.parseInt(rs.getString(1));
                this.username = rs.getString(2);
                this.password = rs.getString(3);
//                System.out.println("RESULT FOUND");
//                System.out.println("IN TABLE: id = " + id);
//                System.out.println("IN TABLE: username = " + username);
//                System.out.println("IN TABLE: password is = " + password);
                userFound = true;
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userFound;
    }

    public boolean authenticateUser(String password) {
        if (this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
