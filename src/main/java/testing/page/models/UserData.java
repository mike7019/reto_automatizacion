package testing.sqa.models;

public class UserData {

    String user;
    String email;
    String password;
    String confPass;

    public UserData(String user, String email, String password, String confPass) {
        this.user = user;
        this.email = email;
        this.password = password;
        this.confPass = confPass;
    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfPass() {
        return confPass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfPass(String confPass) {
        this.confPass = confPass;
    }
}
