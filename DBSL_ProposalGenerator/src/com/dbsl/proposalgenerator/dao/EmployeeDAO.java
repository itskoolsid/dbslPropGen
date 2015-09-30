package com.dbsl.proposalgenerator.dao;

import java.util.List;

import com.dbsl.proposalgenerator.beans.Employee;

public interface EmployeeDAO {
    public void addEmployee(Employee employee);

    public Employee getEmployeeByName(String empName);

    public Employee getEmployeeById(Integer empId);

    public void deleteEmployeeByName(String empName);

    public Employee searchEmployeeByName(String empName);

    public List<Employee> getAllEmployee();

}
