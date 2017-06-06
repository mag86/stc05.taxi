package main.model.pojo;

/**
 *
 */
public class User {

    private long id;
    private String login;
    private String password;
    private boolean isBlocked;

    public User(long id, String login, String password, boolean isBlocked) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isBlocked = isBlocked;
    }

    public User(String login) {
        this.login = login;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
