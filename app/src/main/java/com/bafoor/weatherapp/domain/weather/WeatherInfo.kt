package com.bafoor.weatherapp.domain.weather

data class WeatherInfo(
    // for mapping each day into weather data
    val weatherDataPerDay : Map<Int, List<WeatherData>>, // day1 (0) to the weather of the day
    val currentWeatherData: WeatherData?
)