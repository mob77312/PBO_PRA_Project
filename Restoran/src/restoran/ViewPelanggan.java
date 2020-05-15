/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class ViewPelanggan extends JFrame{
    JLabel lGambar;
    JTextField tkode = new JTextField();
    JLabel nama = new JLabel("Nama :");
    JTextField tnama = new JTextField();
    JLabel harga = new JLabel("Harga  :");
    JTextField tharga = new JTextField();
    JLabel Jenis = new JLabel("Jenis  :");
    JTextField tjenis = new JTextField();
    JButton btnPesanPanel = new JButton("Pesan");
    JButton btnBatalPanel = new JButton("Batal");
    JLabel lNote1 = new JLabel("Langkah Pesan");
    JLabel lNote2 = new JLabel("1. Klik salah satu baris data");
    JLabel lNote3 = new JLabel("2. Klik tombol Pilih");
    JLabel lNote4 = new JLabel("a. Jika klik tombol pilih, maka data akan masuk di form.");
    JLabel lNote5 = new JLabel("b. Jika klik tombol cancel, maka ada akan kosong.");
    JButton btnPilih = new JButton("Pilih");
    JButton btnPesanan = new JButton("Pesanan");
    
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"Kode","Nama","Harga","Jenis"}; //membuat kolom dgn array tipe object;

    public ViewPelanggan() {
        tableModel = new DefaultTableModel(namaKolom,0); //0 menandakan jumlah baris 
        tabel = new JTable(tableModel); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        scrollPane = new JScrollPane(tabel);
        lGambar = new JLabel (new ImageIcon (getClass().getResource("image/aa.png")));
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setVisible(true);
        setLayout(null);
        setSize(600, 400);
        
       
        add(tkode);
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
        add(btnPesanPanel);
        btnPesanPanel.setBounds(20, 105, 90, 20);
        add(btnPesanan);
        btnPesanan.setBounds(240, 105, 90, 20);
        
        add(btnBatalPanel);
        btnBatalPanel.setBounds(130, 105, 90, 20);
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
        add(btnPilih);
        btnPilih.setBounds(480, 240, 90, 20);
        
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

        

