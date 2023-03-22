import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-weather-form',
  templateUrl: './view-weather-form.component.html',
  styleUrls: ['./view-weather-form.component.css']
})
export class ViewWeatherFormComponent {

  @Input()
  cities!: string[];

  constructor( private router: Router ){}

  // getWeather(city: string) {
  //   console.log(city);
  //   this.router.navigate(["/", city])
  // }

}
