package com.andrewkeyes.lordoftherings.service.model

class ListBookChaptersRequest(
    val bookId: String,
    limit: Int? = null,
    page: Int? = null,
    offset: Int? = null,
    where: String? = null
): ListRequest(limit, page, offset, where)
