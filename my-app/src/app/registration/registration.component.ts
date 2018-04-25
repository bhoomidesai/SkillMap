import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Employee }         from '../employee';
import { EmployeeService }  from '../employee.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
employees:Employee[];
 employee: Employee;

  constructor(
    private route: ActivatedRoute,
    private employeeService: EmployeeService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getHero();
  }

  getHero(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.employeeService.getEmployee(id)
      .subscribe(employee => this.employee = employee);
  }

  goBack(): void {
    this.location.back();
  }

 save(): void {
    this.employeeService.updateEmployee(this.employee)
      .subscribe(() => this.goBack());
  }
  add(employee_id: number,employee_name: string, employee_email: string, password: string): void {
    employee_name = employee_name.trim();
    employee_email = employee_email.trim();
    password = password.trim();
    if (!employee_email) { return; }
    // this.employee.employee_id=id;
    // this.employee.employee_name=name;
    // this.employee.employee_email=email;
    // this.employee.password=password;
    this.employeeService.addEmployee({employee_id,employee_name,employee_email,password} as Employee)
      .subscribe(employee => {
        this.employees.push(employee);
      });
  }

}
