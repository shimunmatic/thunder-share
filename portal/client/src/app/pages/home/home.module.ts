import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { componentsAndDirectives, modules } from './dependencies';
import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';

@NgModule({
  declarations: [
    HomeComponent,
    ...componentsAndDirectives
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    ...modules
  ]
})
export class HomeModule { }
