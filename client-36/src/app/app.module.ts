import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PageWeatherFormComponent } from './page-weather-form/page-weather-form.component';
import { ViewWeatherFormComponent } from './page-weather-form/view-weather-form/view-weather-form.component';
import { PageCountryWeatherComponent } from './page-country-weather/page-country-weather.component';
import { ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http'
import { RouterModule, Routes } from '@angular/router';

const appRoutes: Routes = [
  { path: "", component: PageWeatherFormComponent },
  { path: ":country", component: PageCountryWeatherComponent}

]

@NgModule({
  declarations: [
    AppComponent,
    PageWeatherFormComponent,
    ViewWeatherFormComponent,
    PageCountryWeatherComponent
  ],
  imports: [
    BrowserModule, 
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
