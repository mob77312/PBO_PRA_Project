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
public class MVC_Resto {
    ViewResto viewResto = new ViewResto();
    ModelResto modelResto = new ModelResto();
    ControllerResto cResto = new ControllerResto(modelResto,viewResto);

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
