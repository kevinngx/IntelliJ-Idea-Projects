import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TestTwo {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:sqlite:myDatabase.db");
        System.out.println("Database Connected!");

        Statement st = con.createStatement();

        String dropStatement = "DROP TABLE Students";
        st.execute(dropStatement);

        String createStatement = "CREATE TABLE IF NOT EXISTS Students "
                + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT NOT NULL, "
                + "GENDER TEXT"
                + ");";

        st.execute(createStatement);
        System.out.println("Table created!");


        String myPreparedSt = "INSERT into Students (NAME) VALUES (?)";
        //Statement pst = con.prepareStatement(myPreparedSt);
        PreparedStatement pst = con.prepareStatement(myPreparedSt);

        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> genders = new ArrayList<String>();

        Scanner in = new Scanner(System.in);
        System.out.printf("How many students are there?");
        int numStudents = in.nextInt();
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("Enter Name: ");
            names.add(in.nextLine());
            //System.out.printf("Enter Gender: ");
            //genders.add(in.nextLine());
        }

        for (int i = 0; i < names.size(); i++) {
            pst.setString(1, names.get(i));
            //pst.setString(2, genders.get(i));
            pst.execute();
        }


        // Step 4: Use data in program
        System.out.println("Printing results");
        String query = "select * from Students";
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.printf("ID: %s Name: %s Gender: %s", rs.getString(1), rs.getString(2), rs.getString(3));
            System.out.println();
        }

        // Step 5: Close Connection
        con.close();


    }
}
