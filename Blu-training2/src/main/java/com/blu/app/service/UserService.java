package com.blu.app.service;

import com.blu.app.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<User> users;

    public UserService(){
        users = new ArrayList<User>();

        User user1 = new User(1,"Ahmad", 18, "ahmad@gmail.com");
        User user2 = new User(2,"Mohammed", 26, "mohammed@gmail.com");
        User user3 = new User(3,"Hasan", 23, "hasan@gmail.com");
        User user4 = new User(4,"Khaled", 30, "khaled@gmail.com");
        User user5 = new User(5,"Ali", 25, "ali@gmail.com");
        users.addAll(Arrays.asList(user1,user2,user3,user4,user5));
    }

    public List<User> getUsers() {
        if(users.isEmpty()){
            return null;
        }
        return users;
    }
}
