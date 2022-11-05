package com.andrewkeyes.lotr.service

class LordOfTheRingsServiceException(
    val statusCode: Int,
    val responseBody: String,
    message: String
): RuntimeException(message)