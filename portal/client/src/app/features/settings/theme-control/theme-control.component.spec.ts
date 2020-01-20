import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { modules } from '../dependencies';
import { ThemeControlComponent } from './theme-control.component';


describe('ThemeControlComponent', () => {
  let component: ThemeControlComponent;
  let fixture: ComponentFixture<ThemeControlComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ThemeControlComponent ],
      imports: [...modules]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ThemeControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
