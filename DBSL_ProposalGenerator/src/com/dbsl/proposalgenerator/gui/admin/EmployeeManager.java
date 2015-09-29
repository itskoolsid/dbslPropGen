package com.dbsl.proposalgenerator.gui.admin;

import java.util.List;

import com.dbsl.proposalgenerator.beans.Employee;

public interface EmployeeManager {
public void addEmployee(Employee employee);
public Employee editEmployeeByName(String empName);
public void deleteEmployeeByName(String empName);
public Employee searchEmployeeByName(String empName);
public List<Employee> getAllEmployee();
}
