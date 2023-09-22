package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class BuscaCepService {

        public static HttpResponse<String> buscaCep(int s) throws IOException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://viacep.com.br/ws/"+ s + "/json/"))
                    .build();
            HttpResponse<String> response = client.
                    send(request, HttpResponse.BodyHandlers.ofString());

            return response;

        }

}
