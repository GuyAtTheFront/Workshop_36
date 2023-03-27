package iss.nus.server36.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import iss.nus.server36.models.Weather;
import iss.nus.server36.utils.Utils;

@Service
public class WeatherService {
    
    @Value("${api.key.weather}")
    private String API_KEY;

    private final String URL = "https://api.openweathermap.org/data/2.5/weather";

    public Optional<Weather> getWeather(String country) {

        // 1. build URL
        // 2. build request entity with URL and headers
        // 3. instantiate RestTemplate
        // 4. use RestTemplate to exchange RequestEntity for ResponseEntity
        // 5. ResponseEntity.body to get json
        // 6. Unpack json to Model

        String uri = UriComponentsBuilder
                        .fromUriString(URL)
                        .queryParam("q", country)
                        .queryParam("appid", API_KEY)
                        .queryParam("units", "metric")
                        .build()
                        .toUriString();

        System.out.println(uri);

        RequestEntity<Void> req = RequestEntity
                                    .get(uri)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .build();

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> response = null;

        try{

            response = template.exchange(req, String.class);
            Weather weather = Utils.toWeather(Utils.toJson(response.getBody()));
            return Optional.of(weather);

        } catch (Exception httpClietException$NotFoundException) {
            System.out.println("not found");
            return Optional.empty();

        }
    }
}
