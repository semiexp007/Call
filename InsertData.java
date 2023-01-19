import java.sql.*;

public class InsertData {
  public static void main(String[] args) {
    try {
      // Connect to the database
      Connection con = DriverManager.getConnection("jdbc:mysql://hostname:port/dbname", "username", "password");
      
      // Insert sample data
      String sql = "INSERT INTO Calls (From_number, Start_time, End_time, Duration) VALUES (?, ?, ?, ?)";
      PreparedStatement pstmt = con.prepareStatement(sql);
      
      // Insert first row
      pstmt.setString(1, "9999900000");
      pstmt.setTimestamp(2, Timestamp.valueOf("2021-01-13 06:00:05"));
      pstmt.setTimestamp(3, Timestamp.valueOf("2021-01-13 06:23:06"));
      pstmt.setInt(4, 181);
      pstmt.executeUpdate();
      
      // Insert second row
      pstmt.setString(1, "9999902010");
      pstmt.setTimestamp(2, Timestamp.valueOf("2021-01-13 06:12:49"));
      pstmt.setTimestamp(3, Timestamp.valueOf("2021-01-13 06:14:44"));
      pstmt.setInt(4, 115);
      pstmt.executeUpdate();
      
      System.out.println("Data inserted successfully.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
