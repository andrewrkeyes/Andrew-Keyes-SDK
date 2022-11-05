package com.andrewkeyes.lotr.service.model

class ListMovieQuotesRequest(
    val movieId: String,
    limit: Int? = null,
    page: Int? = null,
    offset: Int? = null,
    where: String? = null
): ListRequest(limit, page, offset, where)
