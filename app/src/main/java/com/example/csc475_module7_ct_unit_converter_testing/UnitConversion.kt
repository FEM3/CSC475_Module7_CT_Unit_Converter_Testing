package com.example.csc475_module7_ct_unit_converter_testing

object UnitCoversion {
    fun cToF(celsius: Double): Double {
        return (celsius * 9 / 5) + 32
    }

    fun FtoC(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9
    }
}