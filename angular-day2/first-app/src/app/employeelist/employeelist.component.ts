import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './employee.service';
import { IEmployee } from './employee';

@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent implements OnInit {
  employees: IEmployee[];
  constructor(private _employeeService: EmployeeService) {
    this.employees = _employeeService.getEmp();
  }
  ngOnInit() {
  }

   getEmployees(): void {
         this.employees = this._employeeService.getEmps();
    }
  trackByEmpCode(index: number, employee: any): string {
    return employee.code;
  }

}
