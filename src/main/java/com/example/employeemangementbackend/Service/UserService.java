package com.example.employeemangementbackend.Service;

import com.example.employeemangementbackend.ExceptionClass.UserNotFoundException;
import com.example.employeemangementbackend.Model.NewUser;
import com.example.employeemangementbackend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public NewUser findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    //Create
    public NewUser addUser(NewUser user){
        return userRepo.save(user);
    }

    //Read
    public List<NewUser> getUsers(){
        return userRepo.findAll();
    }

    //REad all
    public NewUser getById(int id){
        return userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User with this id doesn't exists"));
    }
}
