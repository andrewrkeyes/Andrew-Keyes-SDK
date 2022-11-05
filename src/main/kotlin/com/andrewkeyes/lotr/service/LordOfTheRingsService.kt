package com.andrewkeyes.lotr.service

import com.andrewkeyes.lotr.service.client.LordOfTheRingsClient
import com.andrewkeyes.lotr.service.model.*
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.net.http.HttpClient


interface LordOfTheRingsService {

    fun listBooks(listBooksRequest: ListBooksRequest): ListResponse<BookResponse>

    fun getBook(id: String): BookResponse

    fun listBookChapters(listBookChaptersRequest: ListBookChaptersRequest): ListResponse<BookChapterResponse>

    fun listMovies(listMoviesRequest: ListMoviesRequest): ListResponse<MovieResponse>

    fun getMovie(id: String): MovieResponse

    fun listMovieQuotes(listMovieQuotesRequest: ListMovieQuotesRequest): ListResponse<MovieQuoteResponse>

    fun listCharacters(listCharactersRequest: ListCharactersRequest): ListResponse<CharacterResponse>

    fun getCharacter(id: String): CharacterResponse

    fun listCharacterQuotes(listCharacterQuotesRequest: ListCharacterQuotesRequest): ListResponse<CharacterQuoteResponse>

    fun listQuotes(listQuotesRequest: ListQuotesRequest): ListResponse<QuoteResponse>

    fun getQuote(id: String): QuoteResponse

    fun listChapters(listChaptersQuest: ListChaptersRequest): ListResponse<ChapterResponse>

    fun getChapter(id: String): ChapterResponse

    companion object {

        fun builder(apiKey: String): com.andrewkeyes.lotr.service.LordOfTheRingsService {
            val client = HttpClient.newHttpClient()
            val lordOfTheRingsClient = LordOfTheRingsClient(client, apiKey, jacksonObjectMapper().registerModule(JavaTimeModule()))
            return com.andrewkeyes.lotr.service.LordOfTheRingsServiceImpl(lordOfTheRingsClient)
        }
    }
}