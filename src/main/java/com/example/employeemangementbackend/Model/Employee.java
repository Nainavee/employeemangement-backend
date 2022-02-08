package com.example.employeemangementbackend.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private int id;
    @NotBlank(message = "Please Enter your Name")
    private String name;
    @Email(message = "Please Enter a valid Email")
    @NotBlank(message = "Please Enter your Email")
    private String email;
    @NotBlank(message = "Please Enter your Phone number")
    @Size(min = 10,max = 10,message = "Phone number should be 10 digits long")
    @Pattern(regexp = "^\\d{10}$",message = "Invalid Phone number")
    private String phone;
    @NotBlank(message = "Please Enter your Designation")
    private String jobTitle;
    private String imgUrl;

    public Employee(){}

    public Employee(int id, String name, String email, String phone, String jobTitle, String imgUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.jobTitle = jobTitle;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
