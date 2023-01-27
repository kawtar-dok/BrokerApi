package com.weather.demo.utils;

import com.weather.demo.controllers.WeatherService;
import com.weather.demo.dao.WeatherRepository;
import com.weather.demo.models.Weather;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

@Component
public class CronFetch {


    private String location ;
    private LocalDateTime dt;
    private int currentTemp;
    private int humidity;
    private int pressure;

    String defaultUnit;
    String Temp;

    @Autowired
    private WeatherRepository weatherRepository;

    @Scheduled(cron = "0 0 * * * ? ")
    public void getWeatherInfo(){

//      WeatherService weatherService = new WeatherService();
//      JSONObject weather = weatherService.getWeather();
//      System.out.println(weather);
        WeatherService weatherService = new WeatherService();
        Weather weather = new Weather();


        JSONObject mainObject = weatherService.returnMain();
/*
        //gettingIcon from API
        String iconCode = null;
        String weatherDescriptionNew = null;
        JSONArray jsonArray = weatherService.returnWeatherArray();
        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject weatherObj = jsonArray.getJSONObject(i);
            iconCode = weatherObj.getString("icon");
            weatherDescriptionNew = weatherObj.getString("description");
        }

        iconImg.setSource(new ExternalResource("http://openweathermap.org/img/wn/"+iconCode+"@2x.png"));
*/
        location = weather.getCityName();
        defaultUnit = "\u00b0"+"C";
        currentTemp = mainObject.getInt("temp");
        pressure = mainObject.getInt("pressure");
        humidity = mainObject.getInt("humidity");
        dt = weather.getDateTime();
        //        DateTimeFormatter format;
//        format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
   //     LocalDateTime DateTime = LocalDateTime.now(); ;
//        String dt = DateTime.format(format);
        Temp = currentTemp +defaultUnit;



       // weatherRepository.save(new Weather(location,Temp,pressure,humidity));
        weather.setCityName(location);
        weather.setCurrentTemp(currentTemp);
        weather.setPressure(pressure);
        weather.setHumidity(humidity);
        weather.setDateTime(dt);

        weatherRepository.save(weather);

        System.out.println("currently in " +location + " temp: "+ Temp
                +" pressure: "+pressure+" humidity: "+humidity+" dt: "+ dt +" + one" );


    }


}


