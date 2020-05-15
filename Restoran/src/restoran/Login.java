package restoran;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Login {
  String DBurl = "jdbc:mysql://localhost/resto";
  String DBusername = "root";
  String DBpassword = "";  
  Connection conn;
  Statement statement;
  ResultSet resultset;
  String sql;
  
  public Login()
{
    KoneksiDB koneksidb = new KoneksiDB();
    koneksidb.config();
    conn = koneksidb.koneksi;
    statement = koneksidb.statement;
}
  public void Data(ViewLogin viewlogin)
    {
        String username = viewlogin.getUsername().getText();
        String password = viewlogin.getPassword().getText();
         try {
            sql = "SELECT * FROM login WHERE username='"+username+"' AND passoword='"+password+"'";
            resultset = statement.executeQuery(sql);
            if(resultset.next()){
                if(username.equals(resultset.getString("username")) && password.equals(resultset.getString("passoword"))){
                     new MVC_Resto().setVisible(true);
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Username atau Password salah");
                }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

