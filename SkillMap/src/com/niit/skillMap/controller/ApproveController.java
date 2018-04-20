package com.niit.skillMap.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.skillMap.model.Employee;
import com.niit.skillMap.model.EmployeeRepository;
@WebServlet("/approve")
public class ApproveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 EmployeeRepository repository=new EmployeeRepository();
		List<Employee> list = new ArrayList<Employee>();
		try {
			list = repository.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("employeeList", list);
		
		String id = request.getParameter("employee_id");
	        int employeeId = Integer.parseInt(id);        
	       
	        Employee employee=new Employee();
	        employee.setStatus(true);
	        try {
	        	
				repository.statusUpdate(employeeId);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/approve.jsp");  
		        dispatcher.forward(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	        
	        
		 
	}

}
