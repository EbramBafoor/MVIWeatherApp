package com.bafoor.weatherapp.domain.location

import android.location.Location

interface LocationTracker {

    suspend fun getCurrentLocation() : Location?
}