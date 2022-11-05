package com.andrewkeyes.lordoftherings.service.model

import com.fasterxml.jackson.annotation.JsonProperty

data class MovieQuoteResponse (
    @JsonProperty("_id")
    val id: String,
    val chapterName: String
)