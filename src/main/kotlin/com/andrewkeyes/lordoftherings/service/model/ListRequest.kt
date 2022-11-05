package com.andrewkeyes.lordoftherings.service.model

open class ListRequest (
    open val limit: Int?,
    val page: Int?,
    val offset: Int?,
    val where: String?
)