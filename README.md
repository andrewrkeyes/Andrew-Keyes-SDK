# Lord of the Rings SDK
The Lord of the Rings SDK provides an interfacing for interacting with a Lord of the Rings API. 

## Deployment
The library is deployed to Github packages and can be accessed by adding the following dependency to pom.xml:
```
<dependency>
  <groupId>com.andrewkeyes</groupId>
  <artifactId>lord-of-the-rings-sdk</artifactId>
  <version>1.0.3</version>
</dependency>
```

## Usage
To use the SDK, see the following code snippet to create the LordOfTheRingsService and make a request.
```
val apiKey = "fake_api_key"
val lordOfTheRingsService = LordOfTheRingsService.builder(apiKey)

val request = ListCharactersRequest(
    where = "Name=LibLab"
)
val characters = lordOfTheRingsService.listCharacters(request)
```