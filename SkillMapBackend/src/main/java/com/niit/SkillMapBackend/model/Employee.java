package com.niit.SkillMapBackend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	private int employee_id;
	@NonNull
	@Column(name = "email", unique = true)
	private String employee_email;
	@Column
	@NonNull
	private String employee_name;
	@Column
	@NonNull
	private Date employee_DOJ;
	@Column
	@NonNull
	private String role;
	@Column
	@NonNull
	private String city;
	@Column
	@NonNull
	private String password;
	@Column
	@NonNull
	private String contact_no;
	@Column
	private int rating;
	@Column
	private int total_student_tought;
	@Column
	private int total_hours_tought;
	@Column
	private float placement_per;
	@Column
	private String skills;
	@Column
	private String placement_companies;
	@Column
	private String certifications;
	@Column
	private boolean status;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
			this.employee_id = employee_id;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		
			this.employee_email = employee_email;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
			this.employee_name = employee_name;
	}

	public Date getEmployee_DOJ() {
		return employee_DOJ;
	}

	public void setEmployee_DOJ(Date employee_DOJ) {
			this.employee_DOJ = employee_DOJ;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		
			this.password = password;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		
			this.contact_no = contact_no;
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

}
