import { Component, OnInit } from '@angular/core';
import  { EmployeeService } from '../../services/employee.service'

@Component({
  selector: 'app-employee',
  standalone: true,
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent implements OnInit {

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe(
      res => console.log(res),
      err => console.error(err)
    );
    
  }
}
