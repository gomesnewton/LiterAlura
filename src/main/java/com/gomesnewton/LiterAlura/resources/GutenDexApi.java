package com.gomesnewton.LiterAlura.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gomesnewton.LiterAlura.models.SearchWorks;
import com.gomesnewton.LiterAlura.models.Work;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class GutenDexApi {

    private final String URL = "http://gutendex.com/books/";

    public SearchWorks search(String search) {
        try {
            String searchJson = getResponse(URI.create(URL + "?search=" + search
                                    .replace(" ", "%20"))).body();
            return new ObjectMapper().readValue(searchJson, SearchWorks.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Work getBookById(String id) {
        try {
            String workJson = getResponse(URI.create("http://gutendex.com/books/" + id + "/")).body();
            return new ObjectMapper().readValue(workJson, Work.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<String> getResponse(URI uri) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
