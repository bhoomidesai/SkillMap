package com.niit.SkillMapBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SkillMapBackend.model.Employee;

@Transactional
@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Employee> getAllEmployee() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	public boolean insertEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return true;
	}

	public boolean updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return true;
	}

	public Employee getEmployeeById(int eId) {
		return (Employee) sessionFactory.getCurrentSession().createQuery("from Employee where employee_id=" + eId)
				.uniqueResult();
	}

	public boolean deleteEmployee(int eId) {
		sessionFactory.getCurrentSession().delete(getById(eId));
		return true;

	}
	public boolean approveEmployee(int eId)
	{
		  sessionFactory.getCurrentSession().createQuery("update Employee set status=true where employee_id=" + eId);
		  return true;
	}

}
