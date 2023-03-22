package iss.nus.server36.utils;

import java.io.StringReader;

import iss.nus.server36.models.Weather;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Utils {
    
    public static JsonObject toJson(String json) {
        JsonReader reader = Json.createReader(new StringReader(json));
        return reader.readObject();
    }

    public static Weather toWeather(JsonObject json) {
        Weather weather = new Weather();
        weather.setName(json.getString("name"));
        weather.setTemp(json.getJsonObject("main").getJsonNumber("temp").bigDecimalValue().floatValue());
        weather.setTemp_min(json.getJsonObject("main").getJsonNumber("temp_min").bigDecimalValue().floatValue());
        weather.setTemp_max(json.getJsonObject("main").getJsonNumber("temp_max").bigDecimalValue().floatValue());
        weather.setFeels_like(json.getJsonObject("main").getJsonNumber("feels_like").bigDecimalValue().floatValue());
        weather.setMain(json.getJsonArray("weather").getJsonObject(0).getString("main"));
        weather.setDescription(json.getJsonArray("weather").getJsonObject(0).getString("description"));
        weather.setIcon(json.getJsonArray("weather").getJsonObject(0).getString("icon"));
        return weather;
    }

}
