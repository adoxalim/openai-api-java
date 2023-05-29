import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Moderation extends OpenAiApi {
    public Moderation(String endpoint, String apiKey) {
        super(endpoint, apiKey);
    }

    public String makeRequest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String requestBody = String.format("{\"input\": \"%s\"}", input);
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
