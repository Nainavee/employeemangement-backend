package com.example.employeemangementbackend.Repository;

import com.example.employeemangementbackend.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    Employee findByEmail(String email);
}
