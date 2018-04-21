/*package com.niit.skillMap.controller;


import java.io.IOException;
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




@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> list = new ArrayList<Employee>();
		EmployeeRepository repository = new EmployeeRepository();
		String word = request.getParameter("word");
		System.out.println("ser : "+word);
		try {
			list = repository.getSearch(word);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("employeeList", list);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
	       
	        dispatcher.forward(request, response);

	}

}
*/