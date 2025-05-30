package com.gomesnewton.LiterAlura.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GutenDexApi {

    private static GutenDexApi instance;

    private GutenDexApi() {}

    public static GutenDexApi getInstance() {
        if (instance == null) {
            instance = new GutenDexApi();
        }
        return instance;
    }

    public String search(String search) {
        String sch = search.replace(" ", "%20");
        try {
            return getResponse(URI.create("http://gutendex.com/books/?search=" + sch)).body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBook() {
        try {
            return getResponse(URI.create("http://gutendex.com/books/2610/")).body();
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
