import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Employee }         from '../employee';
import { EmployeeService }  from '../employee.service';
@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
employee: Employee;
  constructor(private route: ActivatedRoute,
    private employeeService: EmployeeService,
    private location: Location) { }

  ngOnInit() {
    this.getEmployee();
  }
  getEmployee(): void {
    const id = +this.route.snapshot.paramMap.get('employee_id');
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
}
