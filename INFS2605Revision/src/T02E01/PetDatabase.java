package T02E01;

import java.lang.ClassNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

public class PetDatabase {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        delete();
        connect();
        insertPets();
        printAllPets();
        getPets("Cat");
        getPets("Frog");
    }

    private static void delete() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:petDatabase.db");

        Statement statement = conn.createStatement();
        String createStatement = "DROP TABLE Pets";

        statement.execute(createStatement);
        System.out.println("Table Deleted");
    }

    public static void connect() throws ClassNotFoundException, SQLException{
        //create connection
        //create statement
        //write the four lines which connect your program to the database
        Connection conn = DriverManager.getConnection("jdbc:sqlite:petDatabase.db");

        Statement statement = conn.createStatement();
        String createQuery = "CREATE TABLE IF NOT EXISTS Pets "
                + "(ID String NOT NULL"
                + ", NAME TEXT NOT NULL"
                + ", SPECIES TEXT NOT NULL"
                + ", COLOR TEXT NOT NULL"
                + ", OWNER TEXT NOT NULL"
                + ")";

        statement.execute(createQuery);
        System.out.println("Table Created");
    }

    public static void insertPets() throws SQLException{
        //create connection
        //create statement
        //write the SQL query and the java code to insert all four pets
        Connection conn = DriverManager.getConnection("jdbc:sqlite:petDatabase.db");

        ArrayList<Pets> petsList = new ArrayList<>();
        petsList.add(new Pets(UUID.randomUUID().toString(), "Kitty", "Cat", "Grey", "Andrew"));
        petsList.add(new Pets(UUID.randomUUID().toString(), "Blair", "Cat", "White", "Yenni"));
        petsList.add(new Pets(UUID.randomUUID().toString(), "Mimi", "Frog", "Green", "Katherine"));
        petsList.add(new Pets(UUID.randomUUID().toString(), "QuackyMooMoo", "Dog", "Brown", "Phoebe"));

        String insertQuery = "INSERT INTO Pets (ID, NAME, SPECIES, COLOR, OWNER) "
                + "VALUES(?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);

        for (Pets pet : petsList) {
            preparedStatement.setString(1, pet.getId());
            preparedStatement.setString(2, pet.getName());
            preparedStatement.setString(3, pet.getSpecies());
            preparedStatement.setString(4, pet.getColor());
            preparedStatement.setString(5, pet.getOwner());
            preparedStatement.execute();
        }
    }

    public static void printAllPets() throws SQLException{
        //create connection
        //create statement
        //write the SQL query and the java code to retrieve and print out all pets in the database

        System.out.println("** SEARCH ALL PETS **");

        Connection conn = DriverManager.getConnection("jdbc:sqlite:petDatabase.db");

        Statement statement = conn.createStatement();
        String selectQuery = "SELECT * FROM Pets";

        ResultSet rs = statement.executeQuery(selectQuery);

        while (rs.next()) {
            System.out.println(String.format("%s, %s, %s, %s, %s"
                    , rs.getString(1)
                    , rs.getString(2)
                    , rs.getString(3)
                    , rs.getString(4)
                    , rs.getString(5)
                    )
            );
        }
    }

    public static void getPets(String species) throws SQLException{
        //create connection
        //create statement
        //write the SQL query to retrieve all pets that are of the species specified in the parameters of this method

        System.out.println("** SEARCH FOR SPECIES = " + species + " **");

        Connection conn = DriverManager.getConnection("jdbc:sqlite:petDatabase.db");

//        Statement statement = conn.createStatement();
//        ResultSet rs = statement.executeQuery(selectQuery);

        String selectQuery = "SELECT * FROM Pets WHERE SPECIES = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
        preparedStatement.setString(1, species);

        ResultSet rs = preparedStatement.executeQuery();
        System.out.println("Printing Results");

        while (rs.next()) {
            System.out.println(String.format("%s, %s, %s, %s, %s"
                    , rs.getString(1)
                    , rs.getString(2)
                    , rs.getString(3)
                    , rs.getString(4)
                    , rs.getString(5)
                    )
            );
        }
    }

}