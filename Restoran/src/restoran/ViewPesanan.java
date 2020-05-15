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
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ViewPesanan extends JFrame{
    JLabel lGambar;
    JTextField tkode = new JTextField();
    JTextField tnama = new JTextField();
    JTextField tharga = new JTextField();
    JTextField tjenis = new JTextField();
    JButton btnCancelPanel = new JButton("Cancel");
    JLabel lNote1 = new JLabel("Langkah Cancel");
    JLabel lNote4 = new JLabel("Total :");
    JLabel lNote5 = new JLabel();
    JLabel lNote2 = new JLabel("1. Klik salah satu baris data");
    JLabel lNote3 = new JLabel("2. Klik tombol Cancel");
    JButton btnBalek = new JButton("Kembali");
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"Kode","Nama","Harga","Jenis"}; //membuat kolom dgn array tipe object;

    public ViewPesanan() {
        tableModel = new DefaultTableModel(namaKolom,0); //0 menandakan jumlah baris 
        tabel = new JTable(tableModel); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        scrollPane = new JScrollPane(tabel);
        lGambar = new JLabel (new ImageIcon (getClass().getResource("image/cc.jpg")));
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setVisible(true);
        setLayout(null);
        setSize(600, 400);
        add(lNote1);
        lNote1.setBounds(20, 10, 300, 20);
        add(lNote2);
        lNote2.setBounds(20, 30, 300, 20);
        add(lNote3);
        lNote3.setBounds(20, 50, 300, 20);
        add(lNote4);
        lNote4.setBounds(20, 80, 300, 20);
        add(lNote5);
        lNote5.setBounds(20, 100, 300, 20);
        
        add(btnCancelPanel);
        btnCancelPanel.setBounds(480, 120, 90, 20);
        add(btnBalek);
        btnBalek.setBounds(480, 10, 90, 20);

        add(scrollPane); 
        scrollPane.setBounds(20, 120, 450, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollpane-nya vertikal
         add(lGambar);
        lGambar.setBounds(0,0,600,400);
        
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


