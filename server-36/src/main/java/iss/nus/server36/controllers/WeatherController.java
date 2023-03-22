package iss.nus.server36.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import iss.nus.server36.models.Weather;
import iss.nus.server36.services.WeatherService;
import iss.nus.server36.utils.Utils;

@Controller
@ResponseBody
@CrossOrigin(origins = "*")
@RequestMapping(path="/api/weather", produces=MediaType.APPLICATION_JSON_VALUE)
public class WeatherController {

    @Autowired
    WeatherService weatherService;
    
    @GetMapping()
    public ResponseEntity<Weather> getWeather(@RequestParam String country) {
        
        System.out.println("\n\n\n\n\n country --> " + country);
        Optional<Weather> weatherOpt = weatherService.getWeather(country);
        
        if (weatherOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(weatherOpt.get());
    }

}
