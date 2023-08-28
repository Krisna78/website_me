package connect;
import java.sql.*;
import javax.swing.JOptionPane;
public class connect {
    private static Connection koneksi;
    public static Connection configDB() throws SQLException {
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus_test","root","");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Database tidak terhubung" + e.getMessage());
            System.out.println(e.getMessage());
        }
        return koneksi;
    }
}
