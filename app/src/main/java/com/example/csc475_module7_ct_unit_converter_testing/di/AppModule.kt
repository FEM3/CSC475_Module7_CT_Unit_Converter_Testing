package com.example.csc475_module7_ct_unit_converter_testing.di

import com.example.csc475_module7_ct_unit_converter_testing.converter.DefaultTemperatureConverter
import com.example.csc475_module7_ct_unit_converter_testing.converter.TemperatureConverter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindTemperatureConverter(
        impl: DefaultTemperatureConverter
    ): TemperatureConverter
}
