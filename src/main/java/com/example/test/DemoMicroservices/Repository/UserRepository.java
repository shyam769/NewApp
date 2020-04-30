package com.example.test.DemoMicroservices.Repository;

import com.example.test.DemoMicroservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUserName(String name);
    public User findByUserId(int id);
}
