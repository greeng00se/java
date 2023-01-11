package com.example.simplejava.pattern.ch02_observer;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay display = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurement(100, 65, 12.3f);
        weatherData.setMeasurement(100, 77, 33.3f);
        weatherData.setMeasurement(90, 35, 25.3f);
    }
}
