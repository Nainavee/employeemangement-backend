package com.example.employeemangementbackend;

import com.example.employeemangementbackend.Model.NewUser;
import com.example.employeemangementbackend.Model.UserData;
import com.example.employeemangementbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    Map<String,String> errors;
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signUp(@RequestBody @Valid NewUser user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            errors=new HashMap<>();
            for(FieldError error:bindingResult.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors,HttpStatus.NOT_ACCEPTABLE);
        }
        NewUser e= userService.findByEmail(user.getEmail());
        if(e!=null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserData userData, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            errors=new HashMap<>();
            for(FieldError error:bindingResult.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors,HttpStatus.NOT_ACCEPTABLE);
        }
        NewUser e= userService.findByEmail(userData.getEmail());
        if(e==null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if(e.getPassword().equals(userData.getPassword())){
            return new ResponseEntity<>(e,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
