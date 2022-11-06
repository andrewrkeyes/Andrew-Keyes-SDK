# Design

### Setup
The SDK uses the builder pattern to create the instance of `LordOfTheRingsSerivceImpl` used by the consumer of the library.
`LordOfTheRingsService.builder(apiKey)` is called to pass the API key and create the HttpClient to access the API.

### Interface
There is a single interface `LordOfTheRingsService` to access all of the resource available through the API.
Since the API key is passed during instantiation, it is not required for subsequent calls.

#### Requests
All calls to list resources requires a ListResource object for the respective call. For example:
```
val listChaptersRequest = ListChaptersRequest(
    limit = 500,
    where = "Name=Example chapter name"
)
val listChaptersResponse: ListResponse<ChapterResponse> = lordOfTheRingsService.listChapters(listChaptersRequest)
```
This allows the parameters accepted by the API to be passed easily.

Requests to retrieve a single resource can be called by id:
```
val chapterResponse: ChapterResponse = lordOfTheRingsService.getChapter("test_id")
```

#### Responses
Each call returns either a `ListResponse<T>` or a single resource such as `ChapterResponse`.
ListResponse objects contain the parameters returned for pagination like `limit`, `offset`, `total`, etc. 
The resource objects return the properties returned by the API.

#### Exceptions
The only exception that can occur currently is the API returning an unsuccessfully HTTP status code. 
If an unsuccessful status code is returned, the error is logged and an `LordOfTheRingsServiceexception` is thrown with more information on the error and URI.