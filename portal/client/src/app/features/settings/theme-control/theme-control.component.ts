import { ChangeDetectionStrategy, Component } from '@angular/core';
import { MatSlideToggleChange } from '@angular/material/slide-toggle';
import { ThemeService } from 'src/app/service/theme/theme.service';

@Component({
  selector: 'ts-theme-control',
  templateUrl: './theme-control.component.html',
  styleUrls: ['./theme-control.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ThemeControlComponent {

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
