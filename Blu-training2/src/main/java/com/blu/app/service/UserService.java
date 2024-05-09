package com.blu.app.service;

import com.blu.app.api.model.User;
import com.blu.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(){
    }



    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
        User user = userRepository.findById(id).orElse(null);
        if(user==null){
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Book not found");
        }
        return user;

    }
}
