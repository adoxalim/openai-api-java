import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Translations extends OpenAiApi {
    String x;
    public Translations(String endpoint, String apiKey, String model, String file) {
        super(endpoint, apiKey, model, file);
    }

    public String makeRequest() throws IOException, InterruptedException {
        try {
            URL url = new URL("https://api.openai.com/v1/audio/translations");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + getApiKey());
            connection.setDoOutput(true);

            File file = new File(getFile());

            String boundary = "*****";
            String lineEnd = "\r\n";

            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            OutputStream outputStream = connection.getOutputStream();

            // Add model parameter
            outputStream.write(("--" + boundary + lineEnd).getBytes());
            outputStream.write(("Content-Disposition: form-data; name=\"model\"" + lineEnd + lineEnd).getBytes());
            outputStream.write(model.getBytes());
            outputStream.write(lineEnd.getBytes());

            // Add file parameter
            outputStream.write(("--" + boundary + lineEnd).getBytes());
            outputStream.write(
                    ("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"" + lineEnd)
                            .getBytes());
            outputStream.write(("Content-Type: audio/mpeg" + lineEnd + lineEnd).getBytes());

            // Write file content
            byte[] fileBytes = java.nio.file.Files.readAllBytes(file.toPath());
            outputStream.write(fileBytes);

            // Add closing boundary
            outputStream.write((lineEnd + "--" + boundary + "--" + lineEnd).getBytes());
            outputStream.flush();
            outputStream.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                x=response.toString();
                System.out.println("Response content: " + response.toString());
            } else {
                System.out.println("Request failed with response code: " + responseCode);
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return x;
    }
}
