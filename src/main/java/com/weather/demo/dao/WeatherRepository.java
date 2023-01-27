package com.weather.demo.dao;

import com.weather.demo.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 *
 * Ici, l'interface EmpRepository hérite de l'interface JpaRepository de Spring
 * DATA. Il faut juste préciser la classe "Modele" et le type de la classe qui
 * représente la clé primaire.
 *
 * Spring Data prendra en charge l'implémentation des 04 méthode ci-dessous à
 * condition de réspecter la nomenclature supportée par Spring Data.
 *
 * @Query offre la possinbilité d'exécuter des requêtes plus complexes.
 *
 */


public interface WeatherRepository extends CrudRepository<Weather, Long> {
    List<Weather> findByCityName(String cityName);
  //  List<Weather> findByDate(Date minDate, Date maxDate);

}
