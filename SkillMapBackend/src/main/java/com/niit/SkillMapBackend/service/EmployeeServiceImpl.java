package com.niit.SkillMapBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.SkillMapBackend.dao.EmployeeDAO;
import com.niit.SkillMapBackend.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	public boolean insertEmployee(Employee employee) {
		if (employeeDAO.getEmployeeById(employee.getEmployee_id()) != null) {
			return false;
		} else {
			employeeDAO.insertEmployee(employee);
			return true;
		}
	}

	public boolean updateEmployee(Employee employee) {
		if (employeeDAO.getEmployeeById(employee.getEmployee_id()) != null) {
			employeeDAO.updateEmployee(employee);
			return true;
		} else {
			return false;
		}
	}

	public Employee getEmployeeById(int eId) {
		return employeeDAO.getEmployeeById(eId);
	}

	public boolean deleteEmployee(int eId) {
		if (employeeDAO.getEmployeeById(eId) != null) {
			employeeDAO.deleteEmployee(eId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean approveEmployee(int eId) {
		if (employeeDAO.getEmployeeById(eId) != null) {
			employeeDAO.approveEmployee(eId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	public List<Employee> listApprovedEmployees() {
		return employeeDAO.listApprovedEmployees();
	}

	@Override
	public List<Employee> listNotApprovedEmployees() {
		return employeeDAO.listNotApprovedEmployees();
	}

	@Override
	public List<Employee> searchEmployeesBySkill(String searchString) {
		return employeeDAO.searchEmployeesBySkill(searchString);
	}

}
