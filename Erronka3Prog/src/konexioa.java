import java.sql.*;

public class konexioa {
    public Connection hasi() {
        Connection conexioa = null;
        try {
            conexioa = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_zinema", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexioa;
    }
    
    public void itxi(Connection conexioa) {
        try {
            conexioa.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
