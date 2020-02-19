import { HarnessLoader } from '@angular/cdk/testing';
import { TestbedHarnessEnvironment } from '@angular/cdk/testing/testbed';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { modules } from '../../dependencies';
import { ThemeControlComponent } from '../theme-control.component';
import { ThemeControlComponentHarness } from './theme-control.harness';


fdescribe('ThemeControlComponent', () => {
  let loader: HarnessLoader;
  let fixture: ComponentFixture<ThemeControlComponent>;
  let harness: ThemeControlComponentHarness;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ThemeControlComponent],
      imports: modules
    }).compileComponents();
    fixture = TestBed.createComponent(ThemeControlComponent);
    loader = TestbedHarnessEnvironment.loader(fixture);
    harness = await TestbedHarnessEnvironment.harnessForFixture(fixture, ThemeControlComponentHarness);
  });

  it('loads theme control harness', async () => {
    expect(harness).toBeTruthy();
  });

  it('slider should be checked on light theme', async () => {
    await harness.setLightTheme();
    expect( await harness.isChecked()).toBeTrue();
  });

});
