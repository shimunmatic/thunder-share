import { Component, ChangeDetectionStrategy } from '@angular/core';

@Component({
  selector: 'ts-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class HomeComponent {

  constructor() { }

}
