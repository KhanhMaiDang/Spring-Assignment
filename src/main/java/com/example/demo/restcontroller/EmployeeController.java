package com.example.demo.restcontroller;

import com.example.demo.exception.EmployeeException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

//    @GetMapping("/")
//    public String hello(){
//        return "hello";
//    }

    @GetMapping("/employeeList")
    public List<Employee> getEmployees(){

        return employeeService.getAllEmployee();
    }

    @GetMapping("/{employeeId}")
    public Employee findEmployeeById(@PathVariable Integer employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null)
            throw new EmployeeException(employeeId);
        else
            return employee;
    }

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/updateEmployeeName/{empId}")
    public Employee updateEmployee(@PathVariable Integer empId, @RequestBody String name){
        return employeeService.updateEmployeeName(empId,name);
    }

    @DeleteMapping("/{empId}")
    public HashMap<String, String> deleteEmployee(@PathVariable Integer empId){
        if (employeeService.getEmployeeById(empId) == null){
            throw new EmployeeException(empId);
        }
        else{
            employeeService.deleteEmployee(empId);
            HashMap<String, String> map = new HashMap<>();
            map.put("message","Delete successfully!");
            return map;
        }
    }
}
