import { Injectable, Injector } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  
  constructor(private http: HttpClient) { }
  
  URL_APPI = 'http://localhost:4000/api/employees'

  getEmployees() {
    return this.http.get(this.URL_APPI);
    
  }

}
