package com.andrewkeyes.lordoftherings.service.model

import com.fasterxml.jackson.annotation.JsonProperty

data class BookResponse(
    @JsonProperty("_id")
    val id: String,
    val name: String
)
