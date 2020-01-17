import { FlexLayoutModule } from '@angular/flex-layout';
import { MatButtonModule } from '@angular/material/button';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatToolbarModule } from '@angular/material/toolbar';
import { SettingsModule } from 'src/app/features/settings/settings.module';

export const modules = [
  MatButtonModule,
  MatToolbarModule,
  MatSlideToggleModule,
  SettingsModule,
  FlexLayoutModule
];

export const componentsAndDirectives = [

];
