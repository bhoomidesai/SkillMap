package com.niit.skillMap.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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



@WebServlet("/")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		RequestDispatcher dispatcher;
		switch(path)
		{
		case "/hr":
				hrController(request,response);
			break;
		case "/approve":
				approveController(request,response);
			 break;
		case "/login":
				loginController(request,response);
			break;
		case "/reg":
				registrationRedirectController(request, response);
				break;
		case "/register":
				registrationController(request, response);
				break;
		case "/search":
				searchController(request, response);
				break;
		case "/updateProfile":
				searchController(request, response);
				break;
		case "/edit":
				editController(request, response);
				break;
		 default:
			 dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			 dispatcher.forward(request, response);
			 break;
			
		}	
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void hrController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		EmployeeRepository repository=new EmployeeRepository();
        List<Employee> list = new ArrayList<Employee>();
		try {
			list = repository.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("employeeList", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/approve.jsp");
		dispatcher.forward(request, response);

	}
	public void approveController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	
	{
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
	public void loginController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

	{
		int eid=Integer.parseInt(request.getParameter("eid"));
		String employeePassword=request.getParameter("password");
		
		EmployeeRepository repository = new EmployeeRepository();
		int count = repository.validateEmployee(eid,employeePassword);
		if(count>0)
		{
			Employee employee = new Employee();
			try {
				employee = repository.getById(eid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("employee", employee);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/home.jsp");
			requestDispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("invalid", "Wrong Username or Password try to login again");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			requestDispatcher.forward(request, response);
		}
			
	}
	public void registrationRedirectController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/registration.jsp");
	       
        dispatcher.forward(request, response);
	}
	public void registrationController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

	{
		
		List<String> errorList=new ArrayList<>();
		int employeeId=Integer.parseInt(request.getParameter("eid"));
		String employeeName=request.getParameter("name");
		String employeeEmail=request.getParameter("email");
		String employeePhone=request.getParameter("phone");
		String employeeCity=request.getParameter("city");
		String employeePassword=request.getParameter("password");
		String role = request.getParameter("role");
		
		Employee employee=new Employee();
		employee.setEmployee_id(employeeId);
		employee.setEmployee_name(employeeName);
		employee.setEmployee_email(employeeEmail);
		employee.setContact_no(employeePhone);
		employee.setAddress(employeeCity);
		employee.setPassword(employeePassword);
		employee.setDesignation(role);
		employee.setStatus(false);
		errorList=employee.getMap();
		EmployeeRepository repository=new EmployeeRepository();
		boolean status=false;
		try {
			if(errorList.size()==0)
			{
			status = repository.insertRecords(employee);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status)
		{
			request.setAttribute("invalid", "Successfully registered Try to login");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/reg");
			requestDispatcher.include(request, response);
		}
		else
		{
			request.setAttribute("error", errorList);
			request.setAttribute("employee", employee);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/reg");
			requestDispatcher.forward(request, response);
		}
	}
	public void searchController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

	{
		List<Employee> list = new ArrayList<Employee>();
		EmployeeRepository repository = new EmployeeRepository();
		String word = request.getParameter("word");
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
	public void updateController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

	{
		
		int employeeId=Integer.parseInt(request.getParameter("eid"));
		String employeeName=request.getParameter("name");
		String employeePhone=request.getParameter("phone");
		String employeeEmail=request.getParameter("email");
		String employeeCity=request.getParameter("city");
		String employeeQualification=request.getParameter("qualification");
		String employeeSkill=request.getParameter("skill");
		String employeeCertification=request.getParameter("certification");
		String business_unit=request.getParameter("bu");
		int centreCode=Integer.parseInt(request.getParameter("centercode"));
		String designation = request.getParameter("role");
		String plComp = request.getParameter("plcomp");
		int per = Integer.parseInt(request.getParameter("per"));
		int rate =  Integer.parseInt(request.getParameter("rate"));
		int total_hour_tought=Integer.parseInt(request.getParameter("tht"));
		int total_student_tought=Integer.parseInt(request.getParameter("tst"));
	
		
		java.util.Date date=new java.util.Date();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("doj"));
		} catch (java.text.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	    java.sql.Date doj = new java.sql.Date(date.getTime());
		
		Employee employee=new Employee();
		employee.setEmployee_id(employeeId);
		employee.setEmployee_name(employeeName);
		employee.setEmployee_email(employeeEmail);
		employee.setContact_no(employeePhone);
		employee.setAddress(employeeCity);
		employee.setQualification(employeeQualification);
		employee.setSkills(employeeSkill);
		employee.setCertifications(employeeCertification);
		employee.setCentre_Code(centreCode);
		employee.setDesignation(designation);
		employee.setEmployee_DOJ(doj);
		employee.setBusiness_unit("CEB");
		employee.setPlacement_companies(plComp);
		employee.setPlacement_per(per);
		employee.setRating(rate);
		employee.setTotal_hours_tought(total_hour_tought);
		employee.setCentre_Code(centreCode);
		employee.setTotal_student_tought(total_student_tought);

		
		EmployeeRepository repository=new EmployeeRepository();
		boolean status=true;
		try {
			status = repository.update(employee, employeeId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
	        request.setAttribute("employee", employee);
	        dispatcher.forward(request, response);
			
		}
	}
	public void editController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

	{
		int employeeId = Integer.parseInt(request.getParameter("employee_id"));
        Employee employee = new Employee();
		try {
			employee = new EmployeeRepository().getById(employeeId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/update.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
	}
	
}
