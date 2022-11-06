package com.andrewkeyes.lotr.service.model

class ListChaptersRequest(
    limit: Int? = null,
    page: Int? = null,
    offset: Int? = null,
    where: String? = null,
    sortBy: String? = null,
    sortOrder: SORT_ORDER? = null
): ListRequest(limit, page, offset, where, sortBy, sortOrder)