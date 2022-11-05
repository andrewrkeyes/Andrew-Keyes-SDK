package com.andrewkeyes.lordoftherings.service.model

class ListQuotesRequest(
    limit: Int? = null,
    page: Int? = null,
    offset: Int? = null,
    where: String? = null
): ListRequest(limit, page, offset, where)