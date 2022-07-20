package com.bafoor.weatherapp.domain.repository

import com.bafoor.weatherapp.domain.utils.Resource
import com.bafoor.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(
        latitude : Double,
        longitude : Double
    ) : Resource<WeatherInfo>
}