package restoran;


import javax.swing.JOptionPane;

public class ControllerLogin {
    private ModelLogin model;
    
    public void setModel(ModelLogin model) {
        this.model = model;
    }
  
    public void resetForm(ViewLogin viewLogin) {
        String username = viewLogin.getUsername().getText();
        String password = viewLogin.getPassword().getText();

        if (username.equals("") && password.equals("")) {
        } else {
            model.resetForm();
        }
    }
    public void submitForm(ViewLogin viewLogin) {
        String username = viewLogin.getUsername().getText();
        String password = viewLogin.getPassword().getText();

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username Masih Kosong !");
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password Masih Kosong !");
        } 
        else {
            model.submitForm(viewLogin);
        }
    }
}
