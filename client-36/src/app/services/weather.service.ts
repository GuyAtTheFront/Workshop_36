import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Weather } from '../models';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  private URL = "http://localhost:8080/api/weather";

  constructor( private httpClient: HttpClient ) { }

  getWeather$(country: string) {

    let params = new HttpParams()
                      .append("country", country)

    return this.httpClient.get(`${this.URL}`, {params});
  }
}
