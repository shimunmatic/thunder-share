import { Component, ChangeDetectionStrategy } from '@angular/core';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'ts-default',
  templateUrl: './default.component.html',
  styleUrls: ['./default.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class DefaultComponent {

  environment = environment.name;

  constructor() { }

}
