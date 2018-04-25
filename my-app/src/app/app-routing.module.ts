import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EmployeeHomeComponent }   from './employee-home/employee-home.component';
import { LoginComponent }      from './login/login.component';
import { SkillSearchComponent }      from './skill-search/skill-search.component';
import { RegistrationComponent }  from './registration/registration.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

const routes: Routes = [
 
  { path: 'registration', component: RegistrationComponent },
  { path: 'login', component: LoginComponent },
  { path: 'update/:employee_id', component: UpdateEmployeeComponent },
  { path: 'searchskill', component: SkillSearchComponent },
  { path: 'employeehome', component: EmployeeHomeComponent },
 
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}