package com.bafoor.weatherapp.data.remote

import com.squareup.moshi.Json

// Data that come from API (JSON)
data class WeatherDataDto(

    @field:Json(name = "pressure_msl")
    val pressure: List<Double>,
    @field:Json(name = "relativehumidity_2m")
    val humidity: List<Double>,
    @field:Json(name ="temperature_2m")
    val temperatures: List<Double>,
    val time: List<String>,
    @field:Json(name= "weathercode")
    val weatherCode: List<Int>,
    @field:Json(name= "windspeed_10m")
    val windSpeeds: List<Double>
)