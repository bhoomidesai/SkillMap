package com.niit.SkillMapBackend;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.SkillMapBackend.config.AppContext;
import com.niit.SkillMapBackend.model.Employee;
import com.niit.SkillMapBackend.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppContext.class)
public class EmployeeTest {

	@Autowired
	private EmployeeService employeeService;

	//@Test
	public void testAddEmployee() {

		Employee employee = new Employee();
		employee.setEmployee_name("bhoomi");
		employee.setEmployee_email("bhoomi@gmail.com");
		employee.setEmployee_id(31754);
		employee.setPassword("123");
	/*	employee.setEmployee_DOJ(new Date());
		employee.setCity("Baroda");
		employee.setContact_no("9087654321");
		employee.setRole("employee");*/

		assertEquals(true, employeeService.insertEmployee(employee));

	}

	// @Test()
	public void testAddEmployeeFailure() {

		Employee employee = new Employee();
		employee.setEmployee_name("sonam");
		employee.setEmployee_email("bhoomi@gmail.com");
		employee.setEmployee_id(31754);
		employee.setPassword("123");
	/*	employee.setEmployee_DOJ(new Date());
		employee.setCity("Baroda");
		employee.setContact_no("9087654321");
		employee.setRole("employee");*/

		assertEquals(false, employeeService.insertEmployee(employee));

	}

	// @Test
	public void testUpdateEmployee() {

		Employee employee = new Employee();
		employee.setEmployee_name("sonam");
		employee.setEmployee_email("sonam@gmail.com");
		employee.setEmployee_id(31754);
		employee.setPassword("123");
		/*employee.setEmployee_DOJ(new Date());
		employee.setCity("Baroda");
		employee.setContact_no("9087654321");
		employee.setRole("employee");
		employee.setCertifications("OCA");*/

		assertEquals(true, employeeService.updateEmployee(employee));

	}

	// @Test
	public void testGetByIDEmployee() {

		Employee employee = employeeService.getEmployeeById(31754);
		assertEquals("Matched", employeeService.getEmployeeById(31754).getEmployee_email(),
				employee.getEmployee_email());

	}
	//@Test
	public void deleteEmployeeTest() {

		assertEquals(true, employeeService.deleteEmployee(31754));

	}
	// @Test
	public void testGetAll() {

		assertEquals("Matched", 1, employeeService.getAllEmployees().size());

	}

	// @Test
	public void testApprove() {

		assertEquals(true, employeeService.approveEmployee(31754));

	}

	// @Test
	public void listApprovedEmployeesTest() {

		assertEquals("Matched", 1, employeeService.listApprovedEmployees().size());

	}
	//@Test
	public void listNotApprovedEmployeesTest() {

		assertEquals("Matched", 1, employeeService.listNotApprovedEmployees().size());

	}
	//@Test
	public void searchEmployeesBySkill() {

		assertEquals("Matched", 1, employeeService.searchEmployeesBySkill("java").size());

	}
}
