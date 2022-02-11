import { HttpClient ,HttpParams} from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees:any
  empployeeWorkdays:any
  empployeeRemainingLeaves:any

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    let response = this.http.get("http://localhost:8080/get/employees")
    response.subscribe((data)=> this.employees= data)
  }

  updateWorkDays(empid:String,value:any) {
    let p1= new HttpParams().set("empid",value).set("workday",value)
  
    let response = this.http.get("http://localhost:8080/get/workday",{params:p1})
    response.subscribe((data)=> this.empployeeRemainingLeaves= data)
}
updateLeaves(empid:String,value:any) {
  let p1= new HttpParams().set("empid",value).set("leave",value)
  let response = this.http.get("http://localhost:8080/get/leave",{params:p1})
  response.subscribe((data)=> this.empployeeRemainingLeaves= data)
}
}
