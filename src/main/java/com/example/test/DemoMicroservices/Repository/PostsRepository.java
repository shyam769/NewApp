package com.example.test.DemoMicroservices.Repository;

import com.example.test.DemoMicroservices.model.Posts;
import com.example.test.DemoMicroservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Integer> {
}
