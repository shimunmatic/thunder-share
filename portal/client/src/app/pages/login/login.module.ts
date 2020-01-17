import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { componentsAndDirectives, modules } from './dependencies';


@NgModule({
  declarations: [
    LoginComponent,
    ...componentsAndDirectives
  ],
  imports: [
    CommonModule,
    LoginRoutingModule,
    ...modules
  ]
})
export class LoginModule { }
