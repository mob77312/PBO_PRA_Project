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
public class ControllerResto {
    ModelResto modelResto;
    ViewResto viewResto;
    ControllerResto(ModelResto modelResto, ViewResto viewResto) {
        this.modelResto = modelResto;
        this.viewResto=viewResto;
        if (modelResto.getBanyakData() != 0) { //kalau banyak datanya tidak sama dengan 0
            String dataResto[][] = modelResto.readResto(); //ambil method readResto di model
            viewResto.tabel.setModel((new JTable(dataResto, viewResto.namaKolom)).getModel());
            //menampilkan data yang ada didalam database ke tabel
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        viewResto.btnTambahPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (viewResto.getHarga().equals("")
                        || viewResto.getJenis().equals("")
                        || viewResto.getKode().equals("")
                        || viewResto.getNama().equals("")) {
                    JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                } else {

                    String kode = viewResto.getKode();
                    String nama = viewResto.getNama();
                    String harga = viewResto.getHarga();
                    String jenis = viewResto.getJenis();
          
                 
                    

                    modelResto.insertResto(kode, nama,harga,jenis);
                    viewResto.tkode.setText("");
                    viewResto.tnama.setText("");
                    viewResto.tharga.setText("");
                    viewResto.tjenis.setText("");
                   
                    

                    //untuk menampilkan output langsung tanpa reload
                    String datamvc_resto[][] = modelResto.readResto();
                    viewResto.tabel.setModel(new JTable(datamvc_resto, viewResto.namaKolom).getModel());
                }
            }
        });
        
        viewResto.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //alt+insert
                int baris = viewResto.tabel.getSelectedRow();
                int kolom = viewResto.tabel.getSelectedColumn(); //ga kepake
                
                viewResto.btnHapus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //ngambil nim yang ada di kolom indeks 0   
                        String dataterpilih = viewResto.tabel.getValueAt(baris, 0).toString();

                        System.out.println(dataterpilih);
                        //konfirmasi untuk menghapus
                        int input = JOptionPane.showConfirmDialog(null, 
                        "Apa anda ingin menghapus Kode "+ dataterpilih+ "?", "Pilih Opsi...",JOptionPane.YES_NO_CANCEL_OPTION);

                        if(input==0){
                            modelResto.deleteResto(dataterpilih); //mengambil method hapus di model
                            //untuk menampilkan output langsung tanpa reload
                            String dataResto[][] = modelResto.readResto();
                            viewResto.tabel.setModel(new JTable(dataResto, viewResto.namaKolom).getModel());
                        }else{
                            JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                        }

                    }
                });
                
                viewResto.btnUpdate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String kode = viewResto.tabel.getValueAt(baris, 0).toString();
                        String nama = viewResto.tabel.getValueAt(baris, 1).toString();
                        String harga = viewResto.tabel.getValueAt(baris, 2).toString();
                        String jenis = viewResto.tabel.getValueAt(baris, 3).toString();
          
                         viewResto.tkode.setText(kode);
                         viewResto.tnama.setText(nama);
                         viewResto.tharga.setText(harga);
                         viewResto.tjenis.setText(jenis);
                   
                    }
                });
                
            }
        });
        
        
        viewResto.btnEditPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   if (viewResto.getHarga().equals("")
                        || viewResto.getJenis().equals("")
                        || viewResto.getKode().equals("")
                        || viewResto.getNama().equals("")) {
                    JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                } else {

                    String kode = viewResto.getKode();
                    String nama = viewResto.getNama();
                    String harga = viewResto.getHarga();
                    String jenis = viewResto.getJenis();
          
                 
                    

                    modelResto.updateResto(kode, nama,harga,jenis);
                    viewResto.tkode.setText("");
                    viewResto.tnama.setText("");
                    viewResto.tharga.setText("");
                    viewResto.tjenis.setText("");
                   
                    

                    //untuk menampilkan output langsung tanpa reload
                    String datamvc_resto[][] = modelResto.readResto();
                    viewResto.tabel.setModel(new JTable(datamvc_resto, viewResto.namaKolom).getModel());
                }

            }
        });
        viewResto.btnBatalPanel.addActionListener((ActionEvent e) -> {
            viewResto.tkode.setText("");
            viewResto.tnama.setText("");
            viewResto.tharga.setText("");
            viewResto.tjenis.setText("");
        });

    }  
}
