package com.andrewkeyes.lotr.service

import com.andrewkeyes.lotr.service.client.LordOfTheRingsClient
import com.andrewkeyes.lotr.service.model.*

class LordOfTheRingsServiceImpl(private val lordOfTheRingsClient: LordOfTheRingsClient):
    com.andrewkeyes.lotr.service.LordOfTheRingsService {

    override fun listBooks(listBooksRequest: ListBooksRequest): ListResponse<BookResponse> {
        return lordOfTheRingsClient.listBooks(listBooksRequest)
    }

    override fun getBook(id: String): BookResponse {
        return lordOfTheRingsClient.getBook(id).docs.first()
    }

    override fun listBookChapters(listBookChaptersRequest: ListBookChaptersRequest): ListResponse<BookChapterResponse> {
        return lordOfTheRingsClient.listBookChapters(listBookChaptersRequest)
    }

    override fun listMovies(listMoviesRequest: ListMoviesRequest): ListResponse<MovieResponse> {
        return lordOfTheRingsClient.listMovies(listMoviesRequest)
    }

    override fun getMovie(id: String): MovieResponse {
        return lordOfTheRingsClient.getMovie(id).docs.first()
    }

    override fun listMovieQuotes(listMovieQuotesRequest: ListMovieQuotesRequest): ListResponse<MovieQuoteResponse> {
        return lordOfTheRingsClient.listMovieQuotes(listMovieQuotesRequest)
    }

    override fun listCharacters(listCharactersRequest: ListCharactersRequest): ListResponse<CharacterResponse> {
        return lordOfTheRingsClient.listCharacters(listCharactersRequest)
    }

    override fun getCharacter(id: String): CharacterResponse {
        return lordOfTheRingsClient.getCharacter(id).docs.first()
    }

    override fun listCharacterQuotes(listCharacterQuotesRequest: ListCharacterQuotesRequest): ListResponse<CharacterQuoteResponse> {
        return lordOfTheRingsClient.listCharacterQuotes(listCharacterQuotesRequest)
    }

    override fun listQuotes(listQuotesRequest: ListQuotesRequest): ListResponse<QuoteResponse> {
        return lordOfTheRingsClient.listQuotes(listQuotesRequest)
    }

    override fun getQuote(id: String): QuoteResponse {
        return lordOfTheRingsClient.getQuote(id).docs.first()
    }

    override fun listChapters(listChaptersRequest: ListChaptersRequest): ListResponse<ChapterResponse> {
        return lordOfTheRingsClient.listChapters(listChaptersRequest)
    }

    override fun getChapter(id: String): ChapterResponse {
        return lordOfTheRingsClient.getChapter(id).docs.first()
    }
}