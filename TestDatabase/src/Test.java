import java.sql.*;

public class Test {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:sqlite:myDatabase.db");
        System.out.println("Database Connected!");

        Statement st = con.createStatement();
        String createStatement = "CREATE TABLE IF NOT EXISTS Students "
                + "(ID INTEGER NOT NULL, "
                + "NAME TEXT NOT NULL, "
                + "GENDER TEXT NOT NULL "
                + ");";

        st.execute(createStatement);
        System.out.println("Table created!");

        String insertStatement = "INSERT INTO Students (ID, NAME, GENDER) \n" +
                "VALUES (1001, 'Kevin', 'M'), (1002, 'Joyce', 'F'), (1003, 'Mimi', 'F'), (1004, 'Justin', 'M');";

        st.execute(insertStatement);

        String query = "select * from Students";
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.printf("ID: %s Name: %s Gender: %s", rs.getString(1), rs.getString(2), rs.getString(3));
            System.out.println();
        }





    }
}
