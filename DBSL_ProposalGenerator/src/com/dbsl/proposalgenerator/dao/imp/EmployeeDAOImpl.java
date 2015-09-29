package com.dbsl.proposalgenerator.gui.admin;

import java.util.List;

import com.dbsl.proposalgenerator.beans.Employee;

public class EmployeeManagerImpl implements EmployeeManager {
	final String PERSISTENCE_UNIT = "dbsl";
	JPAContainer<Employee> itemscontainer = JPAContainerFactory.make(Employee.class,
			PERSISTENCE_UNIT);
	@Override
	public void addEmployee(Employee employee) {
		
	}

	@Override
	public Employee editEmployeeByName(String empName) {
		return null;
	}

	@Override
	public void deleteEmployeeByName(String empName) {
		
	}

	@Override
	public Employee searchEmployeeByName(String empName) {
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return null;
	}


}
