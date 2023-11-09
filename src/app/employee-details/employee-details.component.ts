import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
  id: number | undefined;
  employee: Employee | undefined;
  constructor(private route: ActivatedRoute, private employeeService: EmployeeService) {

  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.employee = new Employee();

    if (this.id !== undefined) {
      this.employeeService.getEmployeeById(this.id).subscribe(data => {
        this.employee = data;
      });
    } else {
      // Handle the case where id is undefined, such as displaying an error message or taking appropriate action.
      console.error('Invalid employee ID.');
    }
  }
}