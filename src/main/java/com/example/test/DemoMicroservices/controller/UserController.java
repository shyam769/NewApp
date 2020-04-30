package com.example.test.DemoMicroservices.controller;

import com.example.test.DemoMicroservices.Repository.UserRepository;
import com.example.test.DemoMicroservices.exception.UserNotFounfByIdExcepton;
import com.example.test.DemoMicroservices.exception.UserNotFounfByNameExcept;
import com.example.test.DemoMicroservices.model.Posts;
import com.example.test.DemoMicroservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    public UserRepository userRepositroy;

    @GetMapping("/user/ById/{id}")
    public User getUserById(@PathVariable("id") int id){
        User user = userRepositroy.findByUserId(id);

        if(user == null){

            throw new UserNotFounfByIdExcepton(" ID :"+id);
        }

        return user;

    }

    @GetMapping("/user/{name}")
    public User getUser(@PathVariable("name") String name){
        User user = userRepositroy.findByUserName(name.trim());
        if(user == null){

            throw new UserNotFounfByNameExcept(" Name :"+name);
        }

        return user;

    }
    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers(){

        List<User> temp = userRepositroy.findAll();

        return userRepositroy.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> getAllUsers(@RequestBody User user){

        User savedData =  userRepositroy.save(user);

      URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedData.getUserId()).toUri();


        return ResponseEntity.created(location).build();
    }


    @PutMapping("/users/update/{id}")
    public User updateUser(@RequestBody User newUser,@PathVariable("id") int id){

        User user = userRepositroy.findByUserId(id);
        if(!(user ==null)){

            user.setUserName(newUser.getUserName());
            user.setAddress(newUser.getAddress());

           return userRepositroy.save(user);
        }
        else{
            return userRepositroy.save(newUser);
        }


    }

    @DeleteMapping("/users/deleteById/{id}")
    public void deleteUserById(@PathVariable("id") int id){
        userRepositroy.deleteById(id);
    }



}
