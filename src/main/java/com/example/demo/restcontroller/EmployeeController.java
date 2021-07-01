package com.example.demo.restcontroller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/employeeList")
    public List<Employee> getEmployees(){

        return employeeRepository.findAll();
    }

}
