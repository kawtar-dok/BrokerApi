package com.weather.demo.utils;

import com.weather.demo.controllers.WeatherService;
import com.weather.demo.dao.WeatherRepository;
import com.weather.demo.models.Weather;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.rules.ExternalResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.ImageProducer;
import java.time.LocalDateTime;


@Component
public class CronFetch {


    private String location ;
    private LocalDateTime dt;
    private int currentTemp;
    private int humidity;
    private int pressure;
    private String weatherDescription;
    private String iconImg;
    
    String weatherDescriptionNew = null;
    String iconCode = null;

    String defaultUnit;
    String Temp;

    @Autowired
    private WeatherRepository weatherRepository;

    @Scheduled(cron = "0 0 * * * ? ")
    public void getWeatherInfo(){

//      WeatherService weatherService = new WeatherService();
//      JSONObject weather = weatherService.getWeather();
//      System.out.println(weather);((
        WeatherService weatherService = new WeatherService();
        Weather weather = new Weather();


        JSONObject mainObject = weatherService.returnMain();
/*
        //gettingIcon from API

        JSONArray jsonArray = weatherService.returnWeatherArray();
        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject weatherObj = jsonArray.getJSONObject(i);
            iconCode = weatherObj.getString("icon");
            weatherDescriptionNew = weatherObj.getString("description");
        }

        iconImg.setSource(new ExternalResource("http://openweathermap.org/img/wn/"+iconCode+"@2x.png"));
*/
        //gettingIcon from API

        JSONArray jsonArray = weatherService.returnWeatherArray();
        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject weatherObj = jsonArray.getJSONObject(i);
            iconCode = weatherObj.getString("icon");
            weatherDescriptionNew = weatherObj.getString("description");
        }

        location = weather.getCityName();
        defaultUnit = "\u00b0"+"C";
        currentTemp = mainObject.getInt("temp");
        pressure = mainObject.getInt("pressure");
        humidity = mainObject.getInt("humidity");
        dt = weather.getDateTime();
        Temp = currentTemp +defaultUnit;
        weatherDescription = weatherDescriptionNew;
        iconImg = "http://openweathermap.org/img/wn/"+iconCode+"@2x.png";
        //DateTimeFormatter format;
        //format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        //LocalDateTime DateTime = LocalDateTime.now(); ;
        //String dt = DateTime.format(format);




       // weatherRepository.save(new Weather(location,Temp,pressure,humidity));
        weather.setCityName(location);
        weather.setCurrentTemp(currentTemp);
        weather.setPressure(pressure);
        weather.setHumidity(humidity);
        weather.setDateTime(dt);
        weather.setDescription(weatherDescription);
        weather.setIconImage(iconImg);

        weatherRepository.save(weather);

        System.out.println("currently in " +location + " temp: "+ Temp
                +" pressure: "+pressure+" humidity: "+humidity+" dt: "+ dt + " Description: " + weatherDescription +"icon :" + iconImg);


    }


}


