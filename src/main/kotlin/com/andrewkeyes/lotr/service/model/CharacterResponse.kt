package com.andrewkeyes.lotr.service.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterResponse (
    @JsonProperty("_id")
    val id: String,
    val height: String,
    val race: String,
    val gender: String,
    val birth: String,
    val spouse: String,
    val death: String,
    val realm: String,
    val hair: String,
    val name: String,
    val wikiUrl: String
)