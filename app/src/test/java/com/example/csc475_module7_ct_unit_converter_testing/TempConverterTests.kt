package com.example.csc475_module7_ct_unit_converter_testing

import org.junit.Assert.assertEquals
import org.junit.Test

class TempConverterTests {

    @Test
    fun cToF_freezingPoint_returns32() {
        val result = UnitCoversion.cToF(0.0)
        assertEquals(32.0, result, 0.01)
    }

    @Test
    fun cToF_boilingPoint_returns212() {
        val result = UnitCoversion.cToF(100.0)
        assertEquals(212.0, result, 0.01)
    }

    @Test
    fun FtoC_freezingPoint_returns0() {
        val result = UnitCoversion.FtoC(32.0)
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun FtoC_boilingPoint_returns100() {
        val result = UnitCoversion.FtoC(212.0)
        assertEquals(100.0, result, 0.01)
    }
}
