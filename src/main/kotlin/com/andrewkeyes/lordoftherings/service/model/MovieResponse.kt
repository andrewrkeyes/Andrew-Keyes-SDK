package com.andrewkeyes.lordoftherings.service.model

import com.fasterxml.jackson.annotation.JsonProperty

data class MovieResponse(
    @JsonProperty("_id")
    val id: String,
    val name: String,
    val runtimeInMinutes: Int,
    val budgetInMillions: Int,
    val boxOfficeRevenueInMillions: Int,
    val academyAwardNominations: Int,
    val academyAwardWins: Int,
    val rottenTomatoesScore: Int
)
