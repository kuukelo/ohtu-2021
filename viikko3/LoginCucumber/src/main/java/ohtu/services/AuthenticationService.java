package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        if (username.length() < 3 || password.length() < 8) {
            return true;
        }
        boolean eiKirjaimia = false;
        int pituusUn = username.length();
        int pituusPw = password.length();
        
        for (int i = 0; i < pituusUn; i++) {
            char c = username.charAt(i);
            if (!(c >= 'a' && c <= 'z')) {
                return true;
            } 
        }
        for (int i = 0; i < pituusPw; i++) {
            char c = password.charAt(i);
            if (!Character.isLetter(c)) {
                eiKirjaimia = true;
            }
        }
        if (!eiKirjaimia) {
            return true;
        }
        return false;
    }
}
