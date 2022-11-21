package com.example.spring_blog.repositories;

import com.example.spring_blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
