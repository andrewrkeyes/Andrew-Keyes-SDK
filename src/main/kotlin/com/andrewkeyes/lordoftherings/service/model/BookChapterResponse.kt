package com.andrewkeyes.lordoftherings.service.model

import com.fasterxml.jackson.annotation.JsonProperty

data class BookChapterResponse (
    @JsonProperty("_id")
    val id: String,
    val chapterName: String
)