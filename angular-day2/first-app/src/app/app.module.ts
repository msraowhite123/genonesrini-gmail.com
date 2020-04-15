import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ServerComponent } from './server/server.component';
import { ServersComponent } from './servers/servers.component';
import { EmployeelistComponent } from './employeelist/employeelist.component';
import { EmployeetitlepipePipe } from './employeelist/employeetitlepipe.pipe';
import {EmployeeService} from './employeelist/employee.service'

@NgModule({
  declarations: [
    AppComponent,
    ServerComponent,
    ServersComponent,
    EmployeelistComponent,
    EmployeetitlepipePipe
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
