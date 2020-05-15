package restoran;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ViewLogin extends JFrame implements ActionListener, ListenerLogin {

    JLabel lGambar;
    JTextField txUsername = new JTextField();
    JLabel lUsername = new JLabel("Username");
    JPasswordField pPassword = new JPasswordField();
    JLabel lPassword = new JLabel("Password");
    JButton btnLogin = new JButton("");
    ControllerLogin controllerLogin;
    ModelLogin modelLogin;

    public ViewLogin() {
        setTitle("LOGIN");
        lGambar = new JLabel(new ImageIcon(getClass().getResource("image/cc.jpg")));

        btnLogin = new JButton("Login");
        setSize(500, 500);
        setLayout(null);
        add(txUsername);
        add(lUsername);
        add(pPassword);
        add(lPassword);
        add(btnLogin);
        add(lGambar);

        lUsername.setFont(new java.awt.Font("Century Gothic", 2, 14));
        lPassword.setFont(new java.awt.Font("Century Gothic", 2, 14));
        lUsername.setFont(new java.awt.Font("Futura Bk Bt", 2, 16));
        txUsername.setBounds(100, 192, 260, 30);
        lUsername.setBounds(100, 162, 260, 40);
        lPassword.setBounds(100, 222, 260, 40);
        pPassword.setBounds(100, 252, 260, 30);
        btnLogin.setBounds(130, 290, 200, 40);
        lGambar.setBounds(0, 0, 500, 450);

        btnLogin.addActionListener(this);
        
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        controllerLogin = new ControllerLogin();
        modelLogin = new ModelLogin();
        modelLogin.setLoginListener((ListenerLogin) this);
        controllerLogin.setModel(modelLogin);
    }

    public JTextField getUsername() {
        return txUsername;
    }

    public JPasswordField getPassword() {
        return pPassword;
    }

    public static void main(String[] args) {
        new ViewLogin();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            controllerLogin.submitForm(this);
            setVisible(false);
        }
        
    }

    public void onChange(ModelLogin modelLogin) {
        txUsername.setText(modelLogin.getUsername());
        pPassword.setText(modelLogin.getPassword());
    }
}
