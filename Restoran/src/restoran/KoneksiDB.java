package restoran;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class KoneksiDB {
    Connection koneksi;
    Statement statement;
    String url = "jdbc:mysql://localhost/resto";
    
    public void config(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(url, "root", "");
            statement = koneksi.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
}
