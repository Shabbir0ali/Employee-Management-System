import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://localhost:8080/api/v1/employee";
  constructor(private HttpCleint: HttpClient) { }

  getEmployeesList(): Observable<Employee[]> {
    return this.HttpCleint.get<Employee[]>(`${this.baseURL}`);
  }

  createEmployee(employee : Employee) : Observable<Object>{
    return this.HttpCleint.post(`${this.baseURL}`,employee);
  }
  getEmployeeById(id : number):Observable<Employee>{
    return this.HttpCleint.get<Employee>(`${this.baseURL}/${id}`);
  }

  updateEmployee(id:number,employee : Employee) : Observable<Object>{
    return this.HttpCleint.put(`${this.baseURL}/${id}`,employee);
  }

  deleteEmployee(id:number) : Observable<Object>{
    return this.HttpCleint.delete(`${this.baseURL}/${id}`);
  }
}