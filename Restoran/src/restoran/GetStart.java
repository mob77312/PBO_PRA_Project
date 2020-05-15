/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class GetStart extends JFrame implements ActionListener {
    JLabel lGambar;
   JButton btnResto = new JButton("");
   JButton btnPelanggan = new JButton("");

   public GetStart() {
	setTitle("Restoran");
	setDefaultCloseOperation(3);
        lGambar = new JLabel (new ImageIcon (getClass().getResource("image/as.jpg")));
            btnResto = new JButton ("Restoran");
            btnPelanggan = new JButton ("Pelanggan");
	setSize(996,447);
	setLayout(null);
	add(btnResto);
        add(btnPelanggan);
        add(lGambar);
	btnResto.setBounds(250,270,180,70);
        btnPelanggan.setBounds(550,270,180,70);
        lGambar.setBounds(0,0,996,447);
         btnResto.addActionListener(this);
         btnPelanggan.addActionListener(this);
	setVisible(true);
         btnResto.addActionListener(new ActionListener() {
              @Override
             public void actionPerformed(ActionEvent ae) {
                   setVisible(false);
                  ViewLogin l = new ViewLogin(); //To change body of generated methods, choose Tools | Templates.
                 setVisible (true);
            }
      });
         btnPelanggan.addActionListener(new ActionListener() {
              @Override
             public void actionPerformed(ActionEvent ae) {
                   setVisible(false);
                  MVC_Pelanggan MVC_Pelangan = new MVC_Pelanggan(); //To change body of generated methods, choose Tools | Templates.
                 setVisible (true);
            }
      });
        
   }
public static void main(String[] args) {
        new GetStart();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    
        if (ae.getSource() == btnResto) {
            setVisible(false);
        }
        if (ae.getSource() == btnPelanggan) {
            setVisible(false);
        }
    }
    
}
