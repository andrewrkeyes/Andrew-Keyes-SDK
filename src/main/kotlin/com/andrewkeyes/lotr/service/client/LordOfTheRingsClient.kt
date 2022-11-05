package com.andrewkeyes.lotr.service.client

import com.andrewkeyes.lotr.service.LordOfTheRingsServiceException
import com.andrewkeyes.lotr.service.model.*
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

private const val URL = "https://the-one-api.dev/v2"
private const val API_KEY_HEADER_NAME = "Authorization"

class LordOfTheRingsClient(
    private val client: HttpClient,
    private val apiKey: String,
    private val mapper: ObjectMapper
) {

    private val logger = LoggerFactory.getLogger(LordOfTheRingsClient::class.java)

    fun listBooks(request: ListBooksRequest): ListResponse<BookResponse> {
        val queryParams = buildListQueryParams(request)
        return get("$URL/book?$queryParams")
    }

    fun getBook(id: String): ListResponse<BookResponse> {
        return get("$URL/book/$id")
    }

    fun listBookChapters(request: ListBookChaptersRequest): ListResponse<BookChapterResponse> {
        val queryParams = buildListQueryParams(request)
        return get("$URL/book/${request.bookId}/chapters?$queryParams")
    }

    fun listMovies(request: ListMoviesRequest): ListResponse<MovieResponse> {
        val queryParams = buildListQueryParams(request)
        return get("$URL/movie?$queryParams")
    }

    fun getMovie(id: String): ListResponse<MovieResponse> {
        return get("$URL/movie/$id")
    }

    fun listMovieQuotes(request: ListMovieQuotesRequest): ListResponse<MovieQuoteResponse> {
        val queryParams = buildListQueryParams(request)
        return get("$URL/movies/${request.movieId}/quotes?$queryParams")
    }

    fun listCharacters(request: ListCharactersRequest): ListResponse<CharacterResponse> {
        val queryParams = buildListQueryParams(request)
        return get("$URL/character?$queryParams")
    }

    fun getCharacter(id: String): ListResponse<CharacterResponse> {
        return get("$URL/character/$id")
    }

    fun listCharacterQuotes(request: ListCharacterQuotesRequest): ListResponse<CharacterQuoteResponse> {
        val queryParams = buildListQueryParams(request)
        return get("$URL/character/${request.characterId}/quotes?$queryParams")
    }

    fun listQuotes(request: ListQuotesRequest): ListResponse<QuoteResponse> {
        val queryParams = buildListQueryParams(request)
        return get("$URL/quote?$queryParams")
    }

    fun getQuote(id: String): ListResponse<QuoteResponse> {
        return get("$URL/quote/$id")
    }

    fun listChapters(request: ListChaptersRequest): ListResponse<ChapterResponse> {
        val queryParams = buildListQueryParams(request)
        return get("$URL/chapter?$queryParams")
    }

    fun getChapter(id: String): ListResponse<ChapterResponse> {
        return get("$URL/chapter/$id")
    }

    private fun buildListQueryParams(listRequest: ListRequest): String {
        var queryString = ""
        listRequest.limit?.let { queryString = "$queryString&limit=${listRequest.limit}" }
        listRequest.offset?.let { queryString = "$queryString&offset=${listRequest.offset}" }
        listRequest.page?.let { queryString = "$queryString&page=${listRequest.page}" }
        listRequest.where?.let { queryString = "$queryString&${listRequest.where}" }
        return queryString.removePrefix("&")
    }

    private inline fun <reified T> get(uri: String): T {
        val request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .GET()
            .header(API_KEY_HEADER_NAME, "Bearer $apiKey")
            .build()
        return sendRequest(request)
    }

    private inline fun <reified T> sendRequest(httpRequest: HttpRequest): T {
        val response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString())

        if(response.statusCode() in 200..204) {
            return mapper.readValue(response.body(), T::class.java)
        } else {
            logger.error("Lord of Rings API returned an error for request ${httpRequest.uri()}. Status code: ${response.statusCode()}. Body: ${response.body()}")
            throw com.andrewkeyes.lotr.service.LordOfTheRingsServiceException(
                response.statusCode(),
                response.body(),
                "Lord of Rings API returned an error for request ${httpRequest.uri()}. Status code: ${response.statusCode()}."
            )
        }
    }

}