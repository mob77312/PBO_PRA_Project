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
public class ControllerPesanan {
    ModelPesanan modelPesanan;
    ViewPesanan viewPesanan;
    ControllerPesanan(ModelPesanan modelPesanan, ViewPesanan viewPesanan) {
        this.modelPesanan = modelPesanan;
        this.viewPesanan=viewPesanan;
        if (modelPesanan.getBanyakData() != 0) { //kalau banyak datanya tidak sama dengan 0
            String dataResto[][] = modelPesanan.readResto(); //ambil method readResto di model
            viewPesanan.tabel.setModel((new JTable(dataResto, viewPesanan.namaKolom)).getModel());
            //menampilkan data yang ada didalam database ke tabel
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        viewPesanan.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //alt+insert
                int baris = viewPesanan.tabel.getSelectedRow();
                int kolom = viewPesanan.tabel.getSelectedColumn(); //ga kepake
                
                
                
               viewPesanan.btnCancelPanel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //ngambil nim yang ada di kolom indeks 0   
                        String dataterpilih = viewPesanan.tabel.getValueAt(baris, 0).toString();

                        System.out.println(dataterpilih);
                        //konfirmasi untuk menghapus
                        int input = JOptionPane.showConfirmDialog(null, 
                        "Apa anda ingin menghapus Pesanan "+ dataterpilih+ "?", "Pilih Opsi...",JOptionPane.YES_NO_CANCEL_OPTION);

                        if(input==0){
                            modelPesanan.deleteResto(dataterpilih); //mengambil method hapus di model
                            //untuk menampilkan output langsung tanpa reload
                            String dataResto[][] = modelPesanan.readResto();
                            viewPesanan.tabel.setModel(new JTable(dataResto, viewPesanan.namaKolom).getModel());
                        }else{
                            JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                        }

                    }
                });
                
            }
        });
  
            viewPesanan.btnBalek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MVC_Pelanggan MVC_Pelanggan = new MVC_Pelanggan();
            }
            
        });
    }  
}
