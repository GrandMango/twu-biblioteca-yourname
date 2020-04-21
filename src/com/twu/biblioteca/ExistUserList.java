package com.twu.biblioteca;

import com.twu.biblioteca.entities.User;

import java.util.ArrayList;

public class ExistUserList {
    private ArrayList<User> userList;


    public ExistUserList() {
        userList = new ArrayList<User>();
        userList.add(new User("001-chen", "123456", "yuecheng@gmail.com"));
        userList.add(new User("002-mike", "123456","Mike@gmail.com"));
        userList.add(new User("003-jony", "123456","Jony@gmail.com"));
        userList.add(new User("004-tizz", "123456","Tizz@gmail.com"));
        userList.add(new User("admin", "root","admin@admin.com"));
    }

    public User findUser(String username) {
        for(User user: userList) {
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }

}
