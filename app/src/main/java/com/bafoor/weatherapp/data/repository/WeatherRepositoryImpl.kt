package com.bafoor.weatherapp.data.repository

import com.bafoor.weatherapp.data.mapper.toWeatherInfo
import com.bafoor.weatherapp.data.remote.WeatherApi
import com.bafoor.weatherapp.domain.repository.WeatherRepository
import com.bafoor.weatherapp.domain.utils.Resource
import com.bafoor.weatherapp.domain.weather.WeatherInfo
import java.lang.Exception
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api : WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(
        latitude: Double, longitude: Double
    ): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                api.getWeatherData(
                    latitude, longitude
                ).toWeatherInfo()
            )
        } catch (e : Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "Unknown error occurred")
        }
    }
}















