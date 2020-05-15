/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
class ModelPelanggan {
        //mengkoneksikan ke database. model berisi query2
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/resto";//nama database
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement; //untuk penggunaan query
    public ModelPelanggan(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi gagal");
        }
    }
     public String[][] readResto(){ //dua dimensi (baris-kolom)
      try{
          int jmlData = 0; //menampung jumlah data sebanyak jumlah data yang ada, defaultnya 0
          String data[][] = new String[getBanyakData()][4];//menampung array. barisnya isinya di getBanyakData,kolomnya itu atribut
          String query = "Select * from `mvc_resto`"; //proses pengambilan data
          ResultSet resultSet = statement.executeQuery(query); //result isinya tabel belum berupa string
          while(resultSet.next()){ //konversi tabel ke string
              data[jmlData][0] = resultSet.getString("kode"); //Harus sesuai database
              data[jmlData][1] = resultSet.getString("nama"); //Harus sesuai database
              data[jmlData][2] = resultSet.getString("harga"); //Harus sesuai database
              data[jmlData][3] = resultSet.getString("jenis"); //Harus sesuai database
              jmlData++; //barisnya berpindah terus sampai habis
              //jmlData = baris, kolom 0 nim 1 nama 2 alamat
          }
          return data; 
      }catch(SQLException e){
          System.out.println(e.getMessage());
          System.out.println("SQL Error");
          return null;
      }
  }
      public int getBanyakData(){ //menghitung jumlah baris yg ada
      int jmlData = 0; //nilai awal 0
      try{
          statement = koneksi.createStatement();
          String query = "Select * from `mvc_resto`";
          ResultSet resultSet = statement.executeQuery(query); //pengambilan data dalam java dari database
          while(resultSet.next()){ //ambil nilai dari baris ke 0 sampai baris akhir
              jmlData++;
          }
          return jmlData; //mengembalikan jumlah data ke readResto
      }catch(SQLException e){
          System.out.println(e.getMessage());
          System.out.println("SQL Error");
          return 0;
      }
  }
      
  
  public void updateResto(String kode, String nama, String harga,String jenis){
      try{
         String query = "INSERT INTO `pesan`(`kode`, `nama`, `harga`,`jenis`) VALUES ('"+kode+"','"+nama+"','"+harga+"','"+jenis+"')";
          //String '"+string+"', kalau int "+int+"
          statement = (Statement) koneksi.createStatement();
          statement.executeUpdate(query); //excecute query nya
          System.out.println("Berhasil Dipesan");
          JOptionPane.showMessageDialog(null, "Data Berhasil Dipesan");
          
      }catch(Exception sql){
          System.out.println(sql.getMessage());
          JOptionPane.showMessageDialog(null, sql.getMessage());
      }
      
  }
    public void deleteResto(String kode){ //menghapus data bds nim
        try{
            String query = "DELETE FROM `pesan` WHERE `kode` = '"+kode+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
  }
}

