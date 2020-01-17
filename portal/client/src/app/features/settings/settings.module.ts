import { NgModule } from '@angular/core';
import { SettingsComponent } from './settings.component';
import { componentsAndDirectives, modules } from './dependencies';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [ SettingsComponent, ...componentsAndDirectives ],
  imports: [ CommonModule, ...modules ],
  exports: [ SettingsComponent ]
})
export class SettingsModule { }
