package com.weather.demo.services;

import com.weather.demo.dao.WeatherRepository;
import com.weather.demo.models.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class weatherServiceImpl implements weatherServiceTrue {

    private final WeatherRepository WeatherRepo;

    @Autowired
    public weatherServiceImpl(WeatherRepository weatherRepo) {
        WeatherRepo = weatherRepo;
    }

    @Override
    public List<Weather> getAll() {
        return WeatherRepo.findAll();
    }

    @Override
    public Weather save(Weather weather){
            return WeatherRepo.save(weather);
    }

    @Override
    public Weather getById(Long id) {
        return WeatherRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        WeatherRepo.deleteById(id);
    }
    @Override
    public Weather getLastWeather() {
        return WeatherRepo.findTopByOrderByDateTimeDesc();
    }

}
