package com.bafoor.weatherapp.di

import com.bafoor.weatherapp.data.repository.WeatherRepositoryImpl
import com.bafoor.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ) : WeatherRepository


}






