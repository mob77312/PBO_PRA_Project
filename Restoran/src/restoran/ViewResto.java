/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewResto extends JFrame{
    JLabel lGambar;
    JLabel kode = new JLabel("Kode  :");
    JTextField tkode = new JTextField();
    JLabel nama = new JLabel("Nama :");
    JTextField tnama = new JTextField();
    JLabel harga = new JLabel("Harga  :");
    JTextField tharga = new JTextField();
    JLabel Jenis = new JLabel("Jenis  :");
    JTextField tjenis = new JTextField();
    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnBatalPanel = new JButton("Batal");
    JButton btnEditPanel = new JButton("Edit");
    JLabel lNote1 = new JLabel("Langkah Update dan Hapus Data");
    JLabel lNote2 = new JLabel("1. Klik salah satu baris data");
    JLabel lNote3 = new JLabel("2. Klik tombol Update atau Hapus");
    JLabel lNote4 = new JLabel("a. Jika klik tombol Update, maka data asal keluar di form. Anda bisa edit data disana. Setelah selesai, klik tombol Edit");
    JLabel lNote5 = new JLabel("b. Jika klik tombol Hapus, maka ada menu pop up. Jika akan dihapus, klik tombol Ya");
    JButton btnUpdate = new JButton("Update");
    JButton btnHapus = new JButton("Hapus");
    
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"Kode","Nama","Harga","Jenis"}; //membuat kolom dgn array tipe object;

    public ViewResto() {
        tableModel = new DefaultTableModel(namaKolom,0); //0 menandakan jumlah baris 
        tabel = new JTable(tableModel); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        scrollPane = new JScrollPane(tabel);
        lGambar = new JLabel (new ImageIcon (getClass().getResource("image/cc.jpg")));
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setVisible(true);
        setLayout(null);
        setSize(600, 400);
        
        add(kode);
        kode.setBounds(5, 5, 110, 20);
        add(tkode);
        tkode.setBounds(150, 5, 120, 20);
        add(nama);
        nama.setBounds(5, 30, 140, 20);
        add(tnama);
        tnama.setBounds(150, 30, 120, 20);
        add(harga);
        harga.setBounds(5, 55, 140, 20);
        add(tharga);
        tharga.setBounds(150, 55, 120, 20);
        add(Jenis);
        Jenis.setBounds(5, 80, 140, 20);
        add(tjenis);
        tjenis.setBounds(150, 80, 120, 20);
        add(btnTambahPanel);
        btnTambahPanel.setBounds(20, 105, 90, 20);
        add(btnBatalPanel);
        btnBatalPanel.setBounds(130, 105, 90, 20);
        add(btnEditPanel);
        btnEditPanel.setBounds(240, 105, 90, 20);
        add(lNote1);
        lNote1.setBounds(20, 130, 300, 20);
        add(lNote2);
        lNote2.setBounds(20, 150, 300, 20);
        add(lNote3);
        lNote3.setBounds(20, 170, 300, 20);
        add(lNote4);
        lNote4.setBounds(20, 190, 800, 20);
        add(lNote5);
        lNote5.setBounds(20, 210, 600, 20);
        add(btnUpdate);
        btnUpdate.setBounds(480, 240, 90, 20);
        add(btnHapus);
        btnHapus.setBounds(480, 270, 90, 20);
        
        //TABEL
        add(scrollPane); 
        scrollPane.setBounds(20, 240, 450, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollpane-nya vertikal
        add(lGambar);
        lGambar.setBounds(0,10,600,400);
        
    }
    public String getKode(){
        return tkode.getText();
    }
    public String getNama(){
        return tnama.getText();
    }
    public String getHarga(){
        return tharga.getText();
    }
    public String getJenis(){
           return tjenis.getText();
        
    }

}

