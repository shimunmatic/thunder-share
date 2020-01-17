import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';

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
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    LoginRoutingModule,
    ...materialModules,
    FlexLayoutModule
  ]
})
export class LoginModule { }
