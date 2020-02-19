import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { modules, componentsAndDirectives } from './dependencies';


@NgModule({
  declarations: [
    AdminComponent,
    ...componentsAndDirectives
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ...modules
  ]
})
export class AdminModule { }
