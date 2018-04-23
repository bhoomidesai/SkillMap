package com.niit.SkillMapBackend.dao;

import java.util.List;

import com.niit.SkillMapBackend.model.Employee;

public interface EmployeeDAO 
{
	public List<Employee> getAllEmployee();
	public boolean insertEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public Employee getEmployeeById(int eId);
	public boolean deleteEmployee(int eId);
	public boolean approveEmployee(int eId);
	public List<Employee> listApprovedEmployee();
	public List<Employee> listNotApprovedEmployee();

}
