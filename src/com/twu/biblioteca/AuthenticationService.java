package com.twu.biblioteca;

import com.twu.biblioteca.entities.User;

public class AuthenticationService {
    private User currentUser;
    private ExistUserList userList;

    public AuthenticationService() {
        currentUser = null;
        userList = new ExistUserList();
    }

    public boolean login(String username, String password) {
        User user = userList.findUser(username);
        if(user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return true;
        } else {
            System.out.println("Login failed, please check your username and password again.");
            return false;
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public ExistUserList getUserList() {
        return userList;
    }

    public void setUserList(ExistUserList userList) {
        this.userList = userList;
    }
}
