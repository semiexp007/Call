import java.sql.*;

public class QueryData {
  public static void main(String[] args) {
    try {
      // Connect to the database
      Connection con = DriverManager.getConnection("jdbc:mysql://hostname:port/dbname", "username", "password");

      // 1) Hour of the day when the call volume is highest
      String sql = "SELECT HOUR(Start_time) AS hour, COUNT(*) AS call_count FROM Calls GROUP BY hour ORDER BY call_count DESC LIMIT 1";
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        int highestCallVolumeHour = rs.getInt("hour");
        System.out.println("Hour of the day with highest call volume: " + highestCallVolumeHour);
      }
      
      // 2) Hour of the day when the calls are longest
      sql = "SELECT HOUR(Start_time) AS hour, SUM(Duration) AS call_duration FROM Calls GROUP BY hour ORDER BY call_duration DESC LIMIT 1";
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        int longestCallsHour = rs.getInt("hour");
        System.out.println("Hour of the day with longest calls: " + longestCallsHour);
      }
      
      // 3) Day of the week when the call volume is highest
      sql = "SELECT DAYNAME(Start_time) AS day, COUNT(*) AS call_count FROM Calls GROUP BY DAYNAME(Start_time) ORDER BY call_count DESC LIMIT 1";
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        String highestCallVolumeDay = rs.getString("day");
        System.out.println("Day of the week with highest call volume: " + highestCallVolumeDay);
      }

      // 4) Day of the week when the calls are longest
      sql = "SELECT DAYNAME(Start_time) AS day, SUM(Duration) AS call_duration FROM Calls GROUP BY DAYNAME(Start_time) ORDER BY call_duration DESC LIMIT 1";
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        String longestCallsDay = rs.getString("day");
        System.out.println("Day of the week with longest calls: " + longestCallsDay);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
