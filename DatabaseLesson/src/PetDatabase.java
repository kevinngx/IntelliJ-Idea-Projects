import java.lang.ClassNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PetDatabase {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        connect();
        insertPets();
        printAllPets();
        getPets("Cat");
        getPets("Frog");

    }
    public static void connect() throws ClassNotFoundException, SQLException{
        //create connection
        //create statement
        //write the four lines which connect your program to the database
        Connection con = DriverManager.getConnection("jdbc:sqlite:petDatabase.db");
        System.out.println("Database Connected");

        Statement st = con.createStatement();
        String createStatement = "CREATE TABLE IF NOT EXISTS Pets "
                + "(ID INTEGER NOT NULL, "
                + "NAME TEXT NOT NULL, "
                + "SPECIES TEXT NOT NULL, "
                + "COLOR TEXT NOT NULL, "
                + "OWNER TEXT NOT NULL "
                + ");";

        st.execute(createStatement);
        System.out.println("Table Created!");

    }

    public static void insertPets() throws SQLException{
        //create connection
        //create statement
        //write the SQL query and the java code to insert all four pets

        Connection con = DriverManager.getConnection("jdbc:sqlite:petDatabase.db");

        Statement st = con.createStatement();
        String insertStatement = "INSERT INTO Pets (ID, NAME, SPECIES, COLOR, OWNER)"
                + "VALUES (1001, 'Kitty', 'Cat', 'Grey', 'Andrew'),"
                + "(1002, 'Blair', 'Cat', 'White', 'Yenni'),"
                + "(1003, 'Mimi', 'Frog', 'Green', 'Hatherine'),"
                + "(1004, 'QuackyMooMoo', 'Dog', 'Brown', 'Phoebe');";
        st.execute(insertStatement);

    }

    public static void printAllPets() throws SQLException{
        //create connection
        //create statement
        //write the SQL query and the java code to retrieve and print out all pets in the database

        System.out.println("** SEARCH ALL PETS **");

        Connection con = DriverManager.getConnection("jdbc:sqlite:petDatabase.db");
        Statement st =con.createStatement();

        String query = "select * from Pets";
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getString(2) + " owned by " + rs.getString(5));
        }


    }

    public static void getPets(String species) throws SQLException{
        //create connection
        //create statement
        //write the SQL query to retrieve all pets that are of the species specified in the parameters of this method

        System.out.println("** SEARCH FOR SPECIES = " + species + " **");

        Connection con = DriverManager.getConnection("jdbc:sqlite:petDatabase.db");
        Statement st =con.createStatement();

        String query = "select * from Pets where SPECIES = '" + species + "'";
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getString(2) + " owned by " + rs.getString(5));
        }


    }

}