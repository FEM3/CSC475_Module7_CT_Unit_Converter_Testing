package com.example.csc475_module7_ct_unit_converter_testing

import com.example.csc475_module7_ct_unit_converter_testing.converter.TemperatureConverter
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ViewModelTest {

    @Test
    fun `convertCelsiusToFahrenheit uses converter and updates result`() = runTest {
        val mockConverter = mockk<TemperatureConverter>()
        every { mockConverter.cToF(0.0) } returns 32.0

        val viewModel = TempConversionViewModel(mockConverter)

        viewModel.onInputChanged("0")
        viewModel.convertCelsiusToFahrenheit()

        verify { mockConverter.cToF(0.0) }
        assertEquals("32.00 °F", viewModel.result.first())
    }

    @Test
    fun `convertFahrenheitToCelsius uses converter and updates result`() = runTest {
        val mockConverter = mockk<TemperatureConverter>()
        every { mockConverter.FtoC(32.0) } returns 0.0

        val viewModel = TempConversionViewModel(mockConverter)

        viewModel.onInputChanged("32")
        viewModel.convertFahrenheitToCelsius()

        verify { mockConverter.FtoC(32.0) }
        assertEquals("0.00 °C", viewModel.result.first())
    }
}
