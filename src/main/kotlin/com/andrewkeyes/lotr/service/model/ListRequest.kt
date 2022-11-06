package com.andrewkeyes.lotr.service.model

open class ListRequest (
    open val limit: Int?,
    val page: Int?,
    val offset: Int?,
    val where: String?,
    val sortBy: String?,
    val sortOrder: SORT_ORDER?
)

enum class SORT_ORDER(val apiVal: String) {
    ASC("asc"), DESC("desc");

    override fun toString(): String {
        return apiVal
    }
}