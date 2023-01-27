package com.weather.demo.controllers;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {


    private OkHttpClient client;
    private Response response;
    private String APIKey = "b190341791ce9065733794c66e12b192";


    /* OkHttpClient client = new OkHttpClient();
     Request request = new Request.Builder().url(url).build();
     Response response = client.newCall(request).execute();
     */
    //the issues am stuck in is how to set connection timeout and socket timeout
    public JSONObject getWeather() {
          client = new OkHttpClient();
          Request request = new Request.Builder()
                  .url("https://api.openweathermap.org/data/2.5/weather?q=rabat&units=metric&appid=b190341791ce9065733794c66e12b192")
                  .build();

        try {
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    //filtrate the res
    public JSONArray returnWeatherArray() throws JSONException {
        JSONArray weatherArray = getWeather().getJSONArray("weather");

        return weatherArray;
    }

    public JSONObject returnMain() throws JSONException {
        JSONObject main = getWeather().getJSONObject("main");
        return main;
    }


}
