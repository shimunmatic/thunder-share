import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { componentsAndDirectives, modules } from './dependencies';
import { RegisterRoutingModule } from './register-routing.module';
import { RegisterComponent } from './register.component';


@NgModule({
  declarations: [
    RegisterComponent,
    ...componentsAndDirectives
  ],
  imports: [
    CommonModule,
    RegisterRoutingModule,
    ...modules
  ]
})
export class RegisterModule { }
