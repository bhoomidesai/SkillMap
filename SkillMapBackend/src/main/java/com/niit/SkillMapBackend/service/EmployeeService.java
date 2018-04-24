package com.niit.SkillMapBackend.service;

import java.util.List;

import com.niit.SkillMapBackend.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public boolean insertEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public Employee getEmployeeById(int eId);
	public boolean deleteEmployee(int eId);
	public boolean approveEmployee(int eId);
	public List<Employee> listApprovedEmployees();
	public List<Employee> listNotApprovedEmployees();
	public List<Employee> searchEmployeesBySkill(String searchString);

}
