package com.niit.skillmapfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SkillMapBackend.model.Employee;
import com.niit.SkillMapBackend.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee) {
		
		if (!employeeService.insertEmployee(employee)) {
			return new ResponseEntity<Employee>(employee, HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Employee>> listApprovedEmployees() {
		return new ResponseEntity<List<Employee>>(employeeService.listApprovedEmployees(), HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Employee>> listNotApprovedEmployees() {
		return new ResponseEntity<List<Employee>>(employeeService.listNotApprovedEmployees(), HttpStatus.CREATED);
	}

	@DeleteMapping("/{empId}")
	public ResponseEntity<Employee> removeEmployee(@PathVariable("eid") int id) {

		Employee employee = employeeService.getEmployeeById(id);

		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		
		if (!employeeService.updateEmployee(employee)) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping("approve/{empId}")
	public ResponseEntity<Employee> approveEmployee(@PathVariable("eid") int eid) {

		if (!employeeService.approveEmployee(eid)) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		Employee employee = employeeService.getEmployeeById(eid);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	@GetMapping("search/{searchString}")
	public ResponseEntity<List<Employee>> searchEmployeeBySkill(@PathVariable("searchString") String searchString) {

		return new ResponseEntity<List<Employee>>(employeeService.searchEmployeesBySkill(searchString), HttpStatus.CREATED);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("eid") int eid) {
		
		if(employeeService.getEmployeeById(eid)!=null) {
			return new ResponseEntity<Employee>(employeeService.getEmployeeById(eid), HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND); 
	}
}
