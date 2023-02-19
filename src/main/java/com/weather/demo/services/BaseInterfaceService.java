package com.weather.demo.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseInterfaceService<T> {

    List<T> getAll();

    T save(T baseEntity);

    T getById(Long id);

    void delete(Long id);
}
