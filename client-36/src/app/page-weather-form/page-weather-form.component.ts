import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-page-weather-form',
  templateUrl: './page-weather-form.component.html',
  styleUrls: ['./page-weather-form.component.css']
})
export class PageWeatherFormComponent implements OnInit{

  cities: string[] = ["Singapore", "Kuala Lumpur", "Tokyo", "Bangkok", "Hong Kong", "Beijing"];

  cityForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.cityForm = this.createForm();
  }

  private createForm() : FormGroup{
    let grp =  this.fb.group({
      city: this.fb.control<string>('')
    });
    return grp;
  }

  processForm() {

    const input = this.cityForm.get("city")?.value.toLowerCase().trim();
    this.cityForm = this.createForm();

    if(input.trim() == "") {
      return;
    }

    const idx = this.cities.findIndex(x => x.toLowerCase() === input);
    if (idx < 0) {
      this.cities.push(input)
    }
  }

}
