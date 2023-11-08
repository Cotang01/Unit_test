package sem_3.tdd;

import java.util.Objects;

public class User {

    String name;
    String password;
    boolean isAdmin;
    public boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        if (this.name.equals(name) && this.password.equals(password)) {
            this.isAuthenticate = true;
            return true;
        }
        return false;
    }

}