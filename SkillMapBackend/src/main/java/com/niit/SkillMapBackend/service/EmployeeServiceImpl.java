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

	public List<Employee> getAllService() {
		return employeeDAO.getAll();
	}

	public boolean insertService(Employee employee) {
		if (employeeDAO.getById(employee.getEmployee_id()) != null) {
			return false;
		} else {
			employeeDAO.insert(employee);
			return true;
		}
	}

	public boolean updateService(Employee employee) {
		if (employeeDAO.getById(employee.getEmployee_id()) != null) {
			employeeDAO.update(employee);
			return true;
		} else {
			return false;
		}
	}

	public Employee getByIdService(int eId) {
		return employeeDAO.getById(eId);
	}

	public boolean deleteService(int eId) {
		if (employeeDAO.getById(eId) != null) {
			employeeDAO.delete(eId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean approveService(int eId) {
		if (employeeDAO.getById(eId) != null) {
			employeeDAO.approve(eId);
			return true;
		} else {
			return false;
		}
	}

}
