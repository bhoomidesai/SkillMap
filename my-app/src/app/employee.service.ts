import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import {Employee} from './employee';
import { MessageService } from './message.service';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable()
export class EmployeeService {
 
  private employeeUrl = 'http://localhost:8080/SkillMapFrontend/api/employee'; 
  constructor(
    private http: HttpClient
  ) { }
  getEmployees (): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeeUrl)
  }

  /** GET hero by id. Will 404 if id not found */
  getEmployee(id: number): Observable<Employee> {
    const url = `${this.employeeUrl}/${id}`;
    return this.http.get<Employee>(url)
  }

  /* GET heroes whose name contains search term */
  // searchEmployees(term: string): Observable<Employee[]> {
  //   if (!term.trim()) {
  //     // if not search term, return empty hero array.
  //     return of([]);
  //   }
  //   return this.http.get<Employee[]>(`api/heroes/?name=${term}`)
  // }

  //////// Save methods //////////

  /** POST: add a new hero to the server */
  addEmployee (employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.employeeUrl, employee, httpOptions)
  }

  /** DELETE: delete the hero from the server */
  deleteEmployee (employee: Employee | number): Observable<Employee> {
    const id = typeof employee === 'number' ? employee : employee.employee_id;
    const url = `${this.employeeUrl}/${id}`;

    return this.http.delete<Employee>(url, httpOptions)
  }

  /** PUT: update the hero on the server */
  updateEmployee (employee: Employee): Observable<any> {
    return this.http.put(this.employeeUrl, employee, httpOptions)
  }

}
