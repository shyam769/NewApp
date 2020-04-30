package com.example.test.DemoMicroservices.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name="user")
public class User {

    @Id
    @Column(name ="id")
    @GeneratedValue
    private int userId;
    private String userName;
    private String address;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Posts> postsobj;

    public Set<Posts> getPostsobj() {
        return postsobj;
    }

    public void setPostsobj(Set<Posts> postsobj) {
        this.postsobj = postsobj;
    }

    public User(){

    }

    public User(int userId, String userName, String address) {

        this.userId = userId;
        this.userName = userName;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
