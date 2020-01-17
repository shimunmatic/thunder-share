import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegisterRoutingModule } from './register-routing.module';
import { RegisterComponent } from './register.component';

// import { MatButtonModule } from '@angular/material/button';
// import { MatIconModule } from '@angular/material/icon';
// import { MatInputModule } from '@angular/material/input';
// import { MatTooltipModule } from '@angular/material/tooltip';
// import { MatCardModule } from '@angular/material/card';
import { FlexLayoutModule } from '@angular/flex-layout';

const materialModules = [
  // MatButtonModule,
  // MatIconModule,
  // MatInputModule,
  // MatTooltipModule,
  // MatCardModule,
];

@NgModule({
  declarations: [RegisterComponent],
  imports: [
    CommonModule,
    RegisterRoutingModule,
    ...materialModules,
    FlexLayoutModule
  ]
})
export class RegisterModule { }
