package com.example.employeemangementbackend.Service;

import com.example.employeemangementbackend.ExceptionClass.UserNotFoundException;
import com.example.employeemangementbackend.Model.Employee;
import com.example.employeemangementbackend.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    //Create
    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    //Read all
    public List<Employee> getEmployees(){
        return employeeRepo.findAll();
    }

    //Read
    public Employee getEmployeeById(int id){
        return employeeRepo.findById(id).orElseThrow(()->new UserNotFoundException("User with id "+id+" doesn't exists"));
    }

    //Update
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    //Delete
    public void deleteEmployee(int id){
        employeeRepo.deleteById(id);
    }

    //find by email
    public Employee findByEmail(String email){
       return employeeRepo.findByEmail(email);
    }
}

