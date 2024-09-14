import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../services/employee.service'
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent implements OnInit {

  constructor(public employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  getEmployees() {

    this.employeeService.getEmployees().subscribe({
      next: (res) => {
        this.employeeService.employees = res;
      },
      error: err => {
        console.log(err);
      }, 
      complete: () => {
        console.log('Employee data fetched');
      }
    })
  }

  addEmployee(form: NgForm) {
    this.employeeService.createEmployee(form.value).subscribe({
      next: (res) => {
        this.getEmployees();
        form.reset();
      },
      error: (err) => {
        console.log(err);
      },
      complete: () => {
        console.log('Employee added');
      }
    })
  }
}
