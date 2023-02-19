package com.weather.demo.controllers.rest;

import com.weather.demo.models.Weather;
import com.weather.demo.services.weatherServiceTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class WeatherRestController {

    @Autowired
    private weatherServiceTrue weatherService;

    @Autowired
    public WeatherRestController(weatherServiceTrue weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Weather>> getAll() {
        return new ResponseEntity<>(weatherService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/last-weather")
    public ResponseEntity<Weather> getLastWeather() {
        Weather lastWeather = weatherService.getLastWeather();
        if (lastWeather != null) {
            return new ResponseEntity<>(lastWeather, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
