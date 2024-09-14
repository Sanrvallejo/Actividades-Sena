import { Injectable, Injector } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../models/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  
  
  URL_APPI = 'http://localhost:4000/api/employees'
  
  selectedEmployee : Employee = {
    name: '',
    position: '',
    office: '',                      
    salary: 0,
  };
  employees : Employee[] = [];
  
  constructor(private http: HttpClient) { }
  
  getEmployees() {
    return this.http.get<Employee[]>(this.URL_APPI);
    
  }

  createEmployee(employee: Employee) {
    return this.http.post(this.URL_APPI, employee);
  }

}
