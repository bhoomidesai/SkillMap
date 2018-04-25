import { Component, OnInit } from '@angular/core';
import {Employee} from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrls: ['./employee-home.component.css']
})
export class EmployeeHomeComponent implements OnInit {
  employees: Employee[];
  employee:Employee;
  
  constructor(private employeeService: EmployeeService) { 
    
  }

  ngOnInit() {
    this.getEmployees();
  }
  getEmployees(): void {
    this.employeeService.getEmployees().subscribe(employees => this.employees = employees);
  }
  delete(employee: Employee): void {
    this.employees = this.employees.filter(h => h !== employee);
    this.employeeService.deleteEmployee(employee).subscribe();
  }

}
