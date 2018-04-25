import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';

import { AppComponent }         from './app.component';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import {HttpClientModule, HttpClient} from '@angular/common/http';
import { AppRoutingModule }     from './app-routing.module';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { SkillSearchComponent } from './skill-search/skill-search.component';
import { EmployeeHomeComponent } from './employee-home/employee-home.component';
import { enableProdMode } from '@angular/core';
import { EmployeeService } from './employee.service';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    SkillSearchComponent,
    EmployeeHomeComponent,
    UpdateEmployeeComponent
  ],
  providers:[EmployeeService],
  bootstrap: [ AppComponent ]
})
export class AppModule { }