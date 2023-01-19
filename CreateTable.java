import java.sql.*;

public class CreateTable {
  public static void main(String[] args) {
    try {
      // Connect to the database
      Connection con = DriverManager.getConnection("jdbc:mysql://hostname:port/dbname", "username", "password");
      
      // Create the table
      Statement stmt = con.createStatement();
      String sql = "CREATE TABLE Calls (Call_Id INT AUTO_INCREMENT PRIMARY KEY, From_number VARCHAR(20), Start_time TIMESTAMP, End_Time TIMESTAMP, Duration INT)";
      stmt.executeUpdate(sql);
      
      System.out.println("Table created successfully.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
