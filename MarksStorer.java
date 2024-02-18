import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// Class to interactively store marks of five courses into a database table
public class MarksStorer {

  // Main method to take user inputs and call the method to store marks
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Prompt the user to enter the enrolment number
    System.out.print("Enter the enrolment number: ");
    int enrolment = scanner.nextInt();

    // Prompt the user to enter the marks of five courses
    System.out.print("Enter the marks of course 1: ");
    int course1 = scanner.nextInt();
    System.out.print("Enter the marks of course 2: ");
    int course2 = scanner.nextInt();
    System.out.print("Enter the marks of course 3: ");
    int course3 = scanner.nextInt();
    System.out.print("Enter the marks of course 4: ");
    int course4 = scanner.nextInt();
    System.out.print("Enter the marks of course 5: ");
    int course5 = scanner.nextInt();

    // Close the scanner object
    scanner.close();

    // Call the method that stores the marks into the database table
    storeMarks(enrolment, course1, course2, course3, course4, course5);
  }

  // Method to store marks into the database table using JDBC APIs
  public static void storeMarks(int enrolment, int course1, int course2, int course3, int course4, int course5) {
    // Use a try-with-resources statement to automatically close resources
    try (Connection conn = DatabaseConnector.getConnection()) {
      // SQL query to insert marks into the table
      String sql = "INSERT INTO marks_table VALUES (enrolment, course1, course2, course3, course4, course5)";

      // Use a try-with-resources statement for PreparedStatement
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        // Set parameter values in the statement
        stmt.setInt(1, enrolment);
        stmt.setInt(2, course1);
        stmt.setInt(3, course2);
        stmt.setInt(4, course3);
        stmt.setInt(5, course4);
        stmt.setInt(6, course5);

        // Execute the statement and get the number of rows affected
        int rows = stmt.executeUpdate();

        // Print a success message
        System.out.println("Successfully inserted " + rows + " row(s) into the table.");
      }
    } catch (SQLException e) {
      // Handle exceptions related to database operations
      e.printStackTrace();
    }
  }
}

// Helper class to manage database connection details
class DatabaseConnector {
  // Constants for database connection
  private static final String DB_URL = "jdbc:mysql://localhost:3306/students";
  private static final String DB_USER = "root";
  private static final String DB_PASS = "ayeza";

  // Static block to register the JDBC driver (executed once when the class is
  // loaded)
  static {
    try {
      Class.forName("lib/mysql-connector-j-8.2.0.jar");
    } catch (ClassNotFoundException e) {
      // Handle exceptions related to JDBC driver registration
      e.printStackTrace();
    }
  }

  // Provide a method to get a connection to the database
  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
  }
}