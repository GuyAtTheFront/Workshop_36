import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Weather } from '../models';
import { WeatherService } from '../services/weather.service';

@Component({
  selector: 'app-page-country-weather',
  templateUrl: './page-country-weather.component.html',
  styleUrls: ['./page-country-weather.component.css']
})
export class PageCountryWeatherComponent implements OnInit, OnDestroy {

  weatherDataSub = new Subscription();
  weatherData!: Weather;

  constructor( private activatedRoute: ActivatedRoute,
               private weatherService: WeatherService ) {}


  ngOnInit(): void {
    const country = this.activatedRoute.snapshot.params["country"];
    this.weatherDataSub = this.weatherService.getWeather$(country)
                            // .subscribe(data => this.weatherData = data as Weather, error => console.log(error));
                            .subscribe({
                              next: (data) => this.weatherData = data as Weather, 
                              error: (error) => console.log(error)
                            })
  }

  ngOnDestroy(): void {
    this.weatherDataSub.unsubscribe(); // not necessarily, but good to have
  }

}
