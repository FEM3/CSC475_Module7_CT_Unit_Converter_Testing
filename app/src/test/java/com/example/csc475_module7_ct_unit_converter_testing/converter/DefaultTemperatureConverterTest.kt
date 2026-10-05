package com.example.csc475_module7_ct_unit_converter_testing.converter

import org.junit.Assert.assertEquals
import org.junit.Test

class DefaultTemperatureConverterTest {

    private val converter = DefaultTemperatureConverter()

    @Test
    fun `0 C is 32 F`() {
        assertEquals(32.0, converter.cToF(0.0), 0.01)
    }

    @Test
    fun `100 C is 212 F`() {
        assertEquals(212.0, converter.cToF(100.0), 0.01)
    }

    @Test
    fun `32 F is 0 C`() {
        assertEquals(0.0, converter.FtoC(32.0), 0.01)
    }
}
