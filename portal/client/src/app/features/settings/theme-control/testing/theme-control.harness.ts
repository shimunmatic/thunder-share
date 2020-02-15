import { ComponentHarness } from '@angular/cdk/testing';
import { MatSlideToggleHarness } from '@angular/material/slide-toggle/testing';

export class ThemeControlComponentHarness extends ComponentHarness {

  static hostSelector = 'ts-theme-control';

  protected sliderHarness = this.locatorFor(MatSlideToggleHarness);

  async setDarkTheme() {
    (await this.sliderHarness()).uncheck();
  }

  async setLightTheme() {
    (await this.sliderHarness()).check();
  }

  async isChecked(): Promise<boolean> {
    const sliderHarness = await this.sliderHarness()
    return sliderHarness.isChecked();
  }


}