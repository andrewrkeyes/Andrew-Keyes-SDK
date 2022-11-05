package com.andrewkeyes.lordoftherings.service

import com.andrewkeyes.lordoftherings.service.model.ListBooksRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LordOfTheRingsServiceTest {

    private val lordOfTheRingsService = LordOfTheRingsService.builder("pwyPEcBTfR5bx1HRxzwD")

    @Test
    fun `should work`() {
        val request = ListBooksRequest()
        val response = lordOfTheRingsService.listBooks(request)
        assertEquals("", response)
    }
}