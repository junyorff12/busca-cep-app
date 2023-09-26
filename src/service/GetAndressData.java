package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class GetAndressData {

    public static HttpResponse<String> getAndressData(String cep) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json/"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.
                    send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro na resposta: " + e.getMessage());
        }

        return response;
    }

}
