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
public class MVC_Pesanan {
    ViewPesanan viewpesanan = new ViewPesanan();
    ModelPesanan modelpesanan = new ModelPesanan();
    ControllerPesanan cpesanan = new ControllerPesanan(modelpesanan,viewpesanan);
}
