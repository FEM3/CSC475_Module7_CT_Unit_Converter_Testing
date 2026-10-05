package com.example.csc475_module7_ct_unit_converter_testing

import androidx.lifecycle.ViewModel
import com.example.csc475_module7_ct_unit_converter_testing.converter.TemperatureConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class TempConversionViewModel @Inject constructor(
    private val converter: TemperatureConverter
) : ViewModel() {

    private val _input = MutableStateFlow("")
    val input: StateFlow<String> = _input

    private val _result = MutableStateFlow("")
    val result: StateFlow<String> = _result

    fun onInputChanged(newInput: String) {
        _input.value = newInput
    }

    fun convertCelsiusToFahrenheit() {
        val input = _input.value.toDoubleOrNull()
        _result.value = if (input != null) {
            val converted = converter.cToF(input)
            "%.2f °F".format(converted)
        } else {
            "Invalid input"
        }
    }

    fun convertFahrenheitToCelsius() {
        val input = _input.value.toDoubleOrNull()
        _result.value = if (input != null) {
            val converted = converter.FtoC(input)
            "%.2f °C".format(converted)
        } else {
            "Invalid input"
        }
    }
}