package com.blu.app.api.controller;

import com.blu.app.api.model.User;
import com.blu.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("users")
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService){
       this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<?> getUsers(){

        try {
            List<User> users = userService.getUsers();
            if (users == null) {
                return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        try {
            User user = userService.getUserById(id);
            if (user == null) {
                return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }    }


}
