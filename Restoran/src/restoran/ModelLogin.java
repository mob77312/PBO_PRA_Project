
package restoran;

public class ModelLogin {
    
    private String username;
    private String password;
    private ListenerLogin listenerLogin;

    protected void fireOnChange() {
        if (listenerLogin != null) {
            listenerLogin.onChange(this);
        }
    }

    public ListenerLogin getLoginListener() {
        return listenerLogin;
    }

    public void setLoginListener(ListenerLogin listenerLogin) {
        this.listenerLogin = listenerLogin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        fireOnChange();
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        fireOnChange();
    }

    public void resetForm() {
        setUsername("");
        setPassword("");
    }
    public void submitForm(ViewLogin b) {
        Login input = new Login();
        input.Data(b);
        
    }
}
