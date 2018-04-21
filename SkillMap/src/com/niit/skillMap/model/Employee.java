package com.niit.skillMap.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee
{
	private int employee_id;
	private String employee_email;
	private String employee_name;
	private String qualification;
	private Date employee_DOJ;
	private String business_unit;
	private String designation;
	private String address;
	private String password;
	private String contact_no;
	private int centre_Code;
	private int rating;
	private int total_student_tought;
	private int total_hours_tought;
	private float placement_per;
	private String skills;
	private String placement_companies;
	private String certifications;
	private boolean status;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	private  Pattern emailNamePtrn = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private  Pattern contactptrn = Pattern.compile("^[0-9]{10}$");
	List<String>  errorMap=new ArrayList<>();
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		if(employee_id>0)
		{
		this.employee_id = employee_id;
		}else
		{
			errorMap.add("Id Cannot be left Blank");
		}
	}
	public String getEmployee_email() {
		return employee_email;
	}
	public void setEmployee_email(String employee_email) {
		Matcher mtch = emailNamePtrn.matcher(employee_email);
		if (mtch.matches()) {
			this.employee_email = employee_email;
		}
		else
		{
			errorMap.add("Invalid | Email Cannot be left Blank");
		}
		
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		if(!employee_name.isEmpty())
		{
			this.employee_name = employee_name;
		}else
		{
			errorMap.add("name Cannot be left Blank");
		}
		
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		if(!qualification.isEmpty())
		{
			this.qualification = qualification;
		}else
		{
			errorMap.add("qualification Cannot be left Blank");
		}
		
		
	}
	public Date getEmployee_DOJ() {
		return employee_DOJ;
	}
	public void setEmployee_DOJ(Date employee_DOJ) {
		if(!employee_DOJ.equals(null))
		{
			this.employee_DOJ = employee_DOJ;
		}else
		{
			errorMap.add("Date of Joining Cannot be left Blank");
		}
		
	}
	public String getBusiness_unit() {
		return business_unit;
	}
	public void setBusiness_unit(String business_unit) {
		if(business_unit.isEmpty() || business_unit.equals(null))
		{
			this.business_unit = business_unit;
		}else
		{
			errorMap.add("business unit Cannot be left Blank");
		}
		
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		if(designation.isEmpty())
		{errorMap.add("designation Cannot be left Blank");
			
		}else
		{
			
			this.designation = designation;
		}
		
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address.isEmpty())
		{
			
			errorMap.add("address Cannot be left Blank");
		}else
		{
			this.address = address;
		}
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password.isEmpty())
		{errorMap.add("password Cannot be left Blank");
			
		}else
		{this.password = password;
			
		}
		
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		Matcher mtch = contactptrn.matcher(contact_no);
		if (mtch.matches()) {
			System.out.println("matches");
			this.contact_no = contact_no;
		}else
		{
			errorMap.add( "Contact no should be 10 in numeric digits");
		}
		
	}
	public int getCentre_Code() {
		return centre_Code;
	}
	public void setCentre_Code(int centre_Code) {
		this.centre_Code = centre_Code;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getTotal_student_tought() {
		return total_student_tought;
	}
	public void setTotal_student_tought(int total_student_tought) {
		this.total_student_tought = total_student_tought;
	}
	public int getTotal_hours_tought() {
		return total_hours_tought;
	}
	public void setTotal_hours_tought(int total_hours_tought) {
		this.total_hours_tought = total_hours_tought;
	}
	public float getPlacement_per() {
		return placement_per;
	}
	public void setPlacement_per(float placement_per) {
		this.placement_per = placement_per;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getPlacement_companies() {
		return placement_companies;
	}
	public void setPlacement_companies(String placement_companies) {
		this.placement_companies = placement_companies;
	}
	public String getCertifications() {
		return certifications;
	}
	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}
	public List<String> getMap() {
		// TODO Auto-generated method stub
		return this.errorMap;
	}
	

}
