package com.andrewkeyes.lordoftherings.service.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties
data class CharacterQuoteResponse (
    @JsonProperty("_id")
    val id: String,
    val dialog: String,
    val movie: String,
    val character: String,
)