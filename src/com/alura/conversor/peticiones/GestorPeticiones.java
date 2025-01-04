package com.alura.conversor.peticiones;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GestorPeticiones {

    public static HttpClient crearCliente(){
        return HttpClient.newHttpClient();
    }

    public static HttpRequest crearRequest(String url){
        return HttpRequest.newBuilder().uri(URI.create(url)).build();
    }

    public static HttpResponse<String> crearResponse(HttpClient client, HttpRequest request) throws IOException, InterruptedException {
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
