package com.bafoor.weatherapp.di

import com.bafoor.weatherapp.data.location.DefaultLocationTracker
import com.bafoor.weatherapp.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {



    @Binds
    @Singleton
    abstract fun provideLocationTracker(defaultLocationTracker: DefaultLocationTracker) : LocationTracker











}