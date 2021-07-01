package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Integer empId);
    public Employee createEmployee(Employee employee);
    public Employee updateEmployeeName(Integer employeeId, String name);
    public void deleteEmployee(Integer empId);
}
