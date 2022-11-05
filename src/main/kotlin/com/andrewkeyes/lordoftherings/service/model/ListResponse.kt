package com.andrewkeyes.lordoftherings.service.model

data class ListResponse<T>(
    val docs: List<T>,
    val total: Int,
    val limit: Int,
    val offset: Int,
    val pages: Int,
    val page: Int
)