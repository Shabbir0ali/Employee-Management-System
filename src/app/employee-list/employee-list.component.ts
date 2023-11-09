import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee'
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[] | undefined;

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();
  }
  private getEmployees() {
    this.employeeService.getEmployeesList().subscribe(data => {
      this.employees = data;
    });
  }

  updateEmployee(id: number | undefined) {
    console.log(id);
    this.router.navigate(['update-employee', id]);
  }

  deleteEmployee(id: number | undefined) {
    if (id !== undefined) {
      this.employeeService.deleteEmployee(id).subscribe(data => {
        console.log(data);
        this.getEmployees();
      });
    } else {
      console.error('Invalid employee ID.');
    }
  }

  employeeDetails(id : number | undefined){
    this.router.navigate(['employee-details', id]);
  }
}