package com.andrewkeyes.lordoftherings.service

class LordOfTheRingsServiceException(
    val statusCode: Int,
    val responseBody: String,
    message: String
): RuntimeException(message = message)