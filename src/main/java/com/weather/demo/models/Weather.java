package com.weather.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;



@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name="Weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id")
    private Long id;

    private String cityName = "rabat";
    private int currentTemp;
    private int humidity;
    private int pressure;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name= "date_time")
    private LocalDateTime dateTime = LocalDateTime.now();
    @Column(nullable = true, length = 64)
    private String iconImage;

    public Weather() {
        this.cityName = "rabat";

    }

    public Weather(String cityName, int currentTemp, int humidity, int pressure, String description, LocalDateTime dateTime, String iconImage) {
        this.cityName = cityName;
        this.currentTemp = currentTemp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.description = description;
        this.dateTime = dateTime;
        this.iconImage = iconImage;
    }

    public String getIconImage() {
        return iconImage;
    }

    public void setIconImage(String iconImage) {
        this.iconImage = iconImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(int currentTemp) {
        this.currentTemp = currentTemp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

}
