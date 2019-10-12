import { Component, ChangeDetectionStrategy } from '@angular/core';

@Component({
  selector: 'ts-default',
  templateUrl: './default.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class DefaultComponent {

  constructor() { }

}
