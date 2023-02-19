package com.weather.demo.services;

import com.weather.demo.models.Weather;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface weatherServiceTrue extends BaseInterfaceService<Weather> {
    @Override
    public List<Weather> getAll();

    @Override
    public Weather save(Weather baseEntity);

    @Override
    public Weather getById(Long id);

    @Override
    public void delete(Long id);

    Weather getLastWeather();
}
