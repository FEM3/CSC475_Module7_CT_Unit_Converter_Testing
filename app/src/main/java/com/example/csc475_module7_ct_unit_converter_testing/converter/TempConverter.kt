package com.example.csc475_module7_ct_unit_converter_testing.converter

import javax.inject.Inject

interface TemperatureConverter {
    fun cToF(celsius: Double): Double
    fun FtoC(fahrenheit: Double): Double
}

class DefaultTemperatureConverter @Inject constructor() : TemperatureConverter {
    override fun cToF(celsius: Double): Double = (celsius * 9 / 5) + 32
    override fun FtoC(fahrenheit: Double): Double = (fahrenheit - 32) * 5 / 9
}
