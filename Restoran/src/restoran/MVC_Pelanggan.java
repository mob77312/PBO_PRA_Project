/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran;

/**
 *
 * @author ACER
 */
public class MVC_Pelanggan {

    ViewPelanggan viewpelanggan = new ViewPelanggan();
    ModelPelanggan modelpelanggan = new ModelPelanggan();
    ControllerPelanggan cpelanggan = new ControllerPelanggan(modelpelanggan,viewpelanggan);
    
}
