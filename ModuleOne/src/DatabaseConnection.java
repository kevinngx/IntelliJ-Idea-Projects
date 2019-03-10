import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello, World!");

        makeDatabase();

        insertValue("Kevin", "Nguyen");
        insertValue("Joyce", "Hsu");
        insertValue("Sophia", "Ding");

        searchQuery();

        //dropTable("testTable");


    }

    public static void searchQuery() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:sqlite:testDatabase.db");

        Statement st = con.createStatement();

        String searchQuery = "SELECT * FROM testTable";
        ResultSet rs = st.executeQuery(searchQuery);

        while (rs.next()) {
            System.out.println("Student ID is: " + rs.getString(1));
            System.out.println("Student first name is: " + rs.getString(2));
            System.out.println("Student last name is: " + rs.getString(3));
            System.out.println("");
        }

    }

    public static void insertValue(String FName, String LName) throws SQLException {
        System.out.println("*** Inserting Values ***");
        Connection con = DriverManager.getConnection("jdbc:sqlite:testDatabase.db");

        Statement st = con.createStatement();
        String insertStatement = "INSERT INTO testTable (FIRSTNAME, LASTNAME) "
                + "VALUES ('" + FName + "', '" + LName + "');";

        st.execute(insertStatement);

        System.out.println("Value Added");
        System.out.println("");

    }


    public static void makeDatabase() throws SQLException {
        System.out.println("*** Creating Table ***");
        Connection con = DriverManager.getConnection("jdbc:sqlite:testDatabase.db");

        Statement st = con.createStatement();
        String createStatement = "CREATE TABLE IF NOT EXISTS testTable"
                + "(ID INTEGER PRIMARY KEY autoincrement,"
                + "FIRSTNAME TEXT NOT NULL,"
                + "LASTNAME TEXT NOT NULL "
                + ");";

        st.execute(createStatement);

        System.out.println("Table Created Succesfully");
        System.out.println("");

    }



    public static void dropTable(String tableName) throws SQLException{
        System.out.println("*** Dropping table: " + tableName + " ***");
        Connection con = DriverManager.getConnection("jdbc:sqlite:testDatabase.db");

        Statement st = con.createStatement();
        String deleteStatement = "DROP TABLE " + tableName;

        st.execute(deleteStatement);
        System.out.println("Table Succesfully Dropped");

    }


}
