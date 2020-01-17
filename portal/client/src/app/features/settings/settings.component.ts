import { Component } from '@angular/core';
import { ThemeService } from 'src/app/service/theme/theme.service';
import { MatSlideToggleChange } from '@angular/material/slide-toggle';

@Component({
  selector: 'ts-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent {

  isLight$ = this.theme.isLight$;

  constructor(private theme: ThemeService) { }

  darkTheme() {
    this.theme.setDark();
  }

  lightTheme() {
    this.theme.setLight();
  }

  themeChange(change: MatSlideToggleChange) {
    change.checked ? this.theme.setLight() : this.theme.setDark();
  }

}
