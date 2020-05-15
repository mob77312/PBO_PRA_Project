/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
public class ControllerPelanggan {
    ModelPelanggan modelPelanggan;
    ViewPelanggan viewPelanggan;
    ControllerPelanggan(ModelPelanggan modelPelanggan, ViewPelanggan viewPelanggan) {
        this.modelPelanggan = modelPelanggan;
        this.viewPelanggan=viewPelanggan;
        if (modelPelanggan.getBanyakData() != 0) { //kalau banyak datanya tidak sama dengan 0
            String dataResto[][] = modelPelanggan.readResto(); //ambil method readResto di model
            viewPelanggan.tabel.setModel((new JTable(dataResto, viewPelanggan.namaKolom)).getModel());
            //menampilkan data yang ada didalam database ke tabel
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        viewPelanggan.btnPesanPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (viewPelanggan.getHarga().equals("")
                        || viewPelanggan.getJenis().equals("")
                        || viewPelanggan.getKode().equals("")
                        || viewPelanggan.getNama().equals("")) {
                    JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                } else {

                    String kode = viewPelanggan.getKode();
                    String nama = viewPelanggan.getNama();
                    String harga = viewPelanggan.getHarga();
                    String jenis = viewPelanggan.getJenis();
          
                 
                    

                    modelPelanggan.updateResto(kode, nama,harga,jenis);
                    viewPelanggan.tkode.setText("");
                    viewPelanggan.tnama.setText("");
                    viewPelanggan.tharga.setText("");
                    viewPelanggan.tjenis.setText("");
                   
                    

                    //untuk menampilkan output langsung tanpa reload
                    String datamvc_resto[][] = modelPelanggan.readResto();
                    viewPelanggan.tabel.setModel(new JTable(datamvc_resto, viewPelanggan.namaKolom).getModel());
                }
            }
        });
        
        viewPelanggan.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //alt+insert
                int baris = viewPelanggan.tabel.getSelectedRow();
                int kolom = viewPelanggan.tabel.getSelectedColumn(); //ga kepake
                
                
                
               viewPelanggan.btnPilih.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String kode = viewPelanggan.tabel.getValueAt(baris, 0).toString();
                        String nama = viewPelanggan.tabel.getValueAt(baris, 1).toString();
                        String harga = viewPelanggan.tabel.getValueAt(baris, 2).toString();
                        String jenis = viewPelanggan.tabel.getValueAt(baris, 3).toString();
          
                         viewPelanggan.tkode.setText(kode);
                         viewPelanggan.tnama.setText(nama);
                         viewPelanggan.tharga.setText(harga);
                         viewPelanggan.tjenis.setText(jenis);
                   
                    }
                });
                
            }
        });
        
        
       
        viewPelanggan.btnBatalPanel.addActionListener((ActionEvent e) -> {
            viewPelanggan.tkode.setText("");
            viewPelanggan.tnama.setText("");
            viewPelanggan.tharga.setText("");
            viewPelanggan.tjenis.setText("");
        });
 viewPelanggan.btnPesanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MVC_Pesanan MVC_Pesanan = new MVC_Pesanan();
            }
            
        });
    }  
}
