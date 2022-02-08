package com.example.employeemangementbackend.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserData {
    @Email(message = "Please Enter a valid Email")
    @NotBlank(message = "Please Enter your Email")
    private String email;
    @NotBlank(message = "Please Enter your Password")
    @Size(min = 5,max = 5,message = "Password should be 5 Characters long")
    private String password;

    public UserData() {
    }

    public UserData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
