package com.bafoor.weatherapp.data.mapper

import com.bafoor.weatherapp.data.remote.WeatherDataDto
import com.bafoor.weatherapp.data.remote.WeatherDto
import com.bafoor.weatherapp.domain.weather.WeatherData
import com.bafoor.weatherapp.domain.weather.WeatherInfo
import com.bafoor.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index : Int,
    val data: WeatherData
)

fun WeatherDataDto.toWeatherDateMap() : Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCodes = weatherCode[index]
        val pressure = pressure[index]
        val windSpeeds = windSpeeds[index]
        val humidity = humidity[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeeds,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCodes)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map {
            it.data
        }
    }
}


fun WeatherDto.toWeatherInfo() : WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDateMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }

    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}




