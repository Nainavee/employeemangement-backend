package com.example.employeemangementbackend.Repository;

import com.example.employeemangementbackend.Model.NewUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<NewUser,Integer> {
    NewUser findByEmail(String email);
}
