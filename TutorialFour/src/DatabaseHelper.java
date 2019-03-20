// TODO: Fix up the imports

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseHelper {
    public static void databaseConnectCreate() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:petsDatabase.db");
            Statement st = conn.createStatement();

            // DELETE QUERY
            String deleteStatement = "DROP TABLE Pets";
            st.execute(deleteStatement);

            // TODO: Write an appropriate create query.

            String createStatement = "CREATE TABLE IF NOT EXISTS Pets "
                    + "(ID INTEGER NOT NULL, "
                    + "NAME TEXT NOT NULL, "
                    + "SPECIES TEXT NOT NULL, "
                    + "COLOR TEXT NOT NULL, "
                    + "OWNER TEXT NOT NULL "
                    + ");";

            st.execute(createStatement);

            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertPets() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:petsDatabase.db");
            Statement st = conn.createStatement();

            // TODO: Write appropriate insert queries and execute them

            String insertStatement = "INSERT INTO Pets (ID, NAME, SPECIES, COLOR, OWNER)"
                    + "VALUES (1001, 'Kitty', 'Cat', 'Grey', 'Andrew'),"
                    + "(1002, 'Blair', 'Cat', 'White', 'Yenni'),"
                    + "(1003, 'Mimi', 'Frog', 'Green', 'Hatherine'),"
                    + "(1004, 'QuackyMooMoo', 'Dog', 'Brown', 'Phoebe');";

            st.execute(insertStatement);

            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Pet> listAllPets() {
        ArrayList<Pet> pets = new ArrayList<Pet>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:petsDatabase.db");
            Statement st = conn.createStatement();

            String selectQuery = "SELECT id, name, species, color, owner FROM Pets";
            ResultSet rs = st.executeQuery(selectQuery);

            while(rs.next()){
                pets.add(
                        new Pet(
                                rs.getInt(1)
                                , rs.getString(2)
                                , rs.getString(3)
                                , rs.getString(4)
                                , rs.getString(5)
                        )
                );
            }

            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return pets;
        }
    }
}