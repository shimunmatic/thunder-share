import { ChangeDetectionStrategy, Component } from '@angular/core';
import { ThemeService } from 'src/app/service/theme/theme.service';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'ts-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AdminComponent {

  environment = environment.name;

}
