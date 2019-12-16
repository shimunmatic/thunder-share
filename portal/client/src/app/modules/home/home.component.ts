import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';

@Component({
  selector: 'ts-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  environment = environment.name;
  backend = environment.url;

  date = 'unknown';
  data = 'undefined';

  constructor(private http: HttpClient) { }

  getData() {
    this.http.get(environment.url, { responseType: 'text' })
    .pipe(catchError(err => of('URL3 can not be fetched')))
    .subscribe(result => {
      this.date = new Date().toISOString();
      this.data = result;
      console.log(result);
    });
  }

}
