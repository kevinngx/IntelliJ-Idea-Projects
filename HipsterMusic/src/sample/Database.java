package sample;

import java.sql.*;

public class Database {

    public static Connection conn;

    /* NO NEED TO CALL THIS METHOD OUTSIDE THE DATABASE CLASS */
    public static void openConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:indiefyDB.db");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /* Pass an SQL String into this method when querying the database */
    public ResultSet getResultSet(String sqlstatement) throws SQLException {
        openConnection();
        java.sql.Statement statement = conn.createStatement();
        ResultSet RS = statement.executeQuery(sqlstatement);
        return RS;
    }

    /* Pass an SQL String into this method when inserting data into the database */
    public void insertStatement(String insert_query) throws SQLException {
        java.sql.Statement statement = null;
        openConnection();
        conn.setAutoCommit(false);
        try {
            System.out.println("Database opened successfully");
            statement = conn.createStatement();
            System.out.println("The query was: " + insert_query);
            statement.executeUpdate(insert_query);
            System.out.println("Insertion successful!");
            statement.close();
            conn.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        statement.close();
    }

    public static void createLoginTable() throws ClassNotFoundException, SQLException {
        openConnection();
        try {

            System.out.println("Database opened successfully");

            Statement statement = conn.createStatement();
            String createQuery = "CREATE TABLE \"Login\" (\n" +
                    "\t\"ID\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                    "\t\"USERNAME\"\tTEXT UNIQUE,\n" +
                    "\t\"PASSWORD\"\tTEXT\n" +
                    ");";

            System.out.println("The query was: " + createQuery);

            statement.execute(createQuery);
            System.out.println("Table Created!");

        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
    }

    public static void createMusicTable() throws ClassNotFoundException, SQLException {
        openConnection();

        try {

            System.out.println("Database opened successfully");

            Statement statement = conn.createStatement();
            String createQuery = "CREATE TABLE \"Music\" (\n" +
                    "\t\"ALBUM_ID\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                    "\t\"ARTIST\"\tTEXT,\n" +
                    "\t\"GENRE\"\tTEXT,\n" +
                    "\t\"YEAR\"\tTEXT\n" +
                    ");";

            System.out.println("The query was: " + createQuery);

            statement.execute(createQuery);
            System.out.println("Table Created!");

        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }

    }

}
