import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;


public class Embedding extends OpenAiApi{

    public Embedding(String endpoint, String apiKey) {
        super(endpoint, apiKey);
    }
    public String makeRequest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String requestBody = String.format("{\"model\": \"%s\",\"input\": \"%s\"}",model, input);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        java.net.http.HttpResponse<String> response = client.send(request,
                java.net.http.HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}