/*package com.niit.skillmapfrontend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.SkillMapBackend.model.Employee;
import com.niit.SkillMapBackend.service.EmployeeService;

@Controller
public class EmployeeController {

	//@RequestMapping("/")
	public String getAllEmployees() {
		//model.addAttribute("employee",new Employee());
		//model.addAttribute("employees",employeeService.getAllService());
		
		return "index";
	}
	
	@PostMapping("/employee/add")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		
		if(employee.getEmployee_id()==0) {
			employeeService.insertService(employee);
		}
		else {
			employeeService.updateService(employee);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/remove/{eid}")
	public String removeEmployee(@PathVariable("eid") int id){
		
		System.out.println("inside remove method");
		employeeService.deleteService(id);
        return "redirect:/";
    }
 
    @GetMapping("/edit/{eid}")
    public String editEmployee(@PathVariable("eid") int id, Model model){
        model.addAttribute("employee", employeeService.getByIdService(id));
        model.addAttribute("employees",employeeService.getAllService());
        return "index";
    }
	
}
*/