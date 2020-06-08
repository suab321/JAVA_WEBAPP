package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Entity.Chat;
import com.example.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
