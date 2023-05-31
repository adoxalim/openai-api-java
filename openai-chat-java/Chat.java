import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

class Chat extends OpenAIRequest {
    ArrayList<Message> message;
    JSONArray messageArray;
    String jsonInputString;

    public Chat() {
        super();
        setEndPoint("https://api.openai.com/v1/chat/completions");
    }

    public Chat(String model) {
        super(model);
        setEndPoint("https://api.openai.com/v1/chat/completions");

    }

    public String getResponse() {

        try {
            URL url = new URL(getEndPoint());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + getApiKey());
            con.setDoOutput(true);
            message = getMessages();
            messageArray = new JSONArray();
            String messageJson = "";

            for (Message messages : message) {
                if (message.indexOf(messages) != 0 && message.indexOf(messages) != -1) {
                    messageJson = messageJson.concat(",");
                }

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("role", messages.getRole());
                jsonObject.put("content", messages.getContent());
                if (messages.getName() != "")
                    jsonObject.put("name", messages.getName());
                messageArray.put(jsonObject);
                messageJson = messageJson.concat(jsonObject.toString());

            }

            jsonInputString = String.format("{\"model\":\"%s\",\"messages\":[%s]", getModel(), messageJson.toString());

            if (getN() != 1) {
                jsonInputString = jsonInputString.concat(",\"n\":" + getN());
            }
            if (getMaxTokens() != 1) {
                jsonInputString = jsonInputString.concat(",\"max_tokens\":" + getMaxTokens());
            }
            if (getFrequencyPenalty() != 0.0) {
                jsonInputString = jsonInputString.concat(",\"frequency_penalty\":" + getFrequencyPenalty());

            }
            if (getPresencePenalty() != 0.0) {
                jsonInputString = jsonInputString.concat(",\"presence_penalty\":" + getPresencePenalty());

            }
            if (getStop() != null) {
                jsonInputString = jsonInputString.concat(",\"stop\":" + getStop());

            }
            if (getStream() == true) {
                jsonInputString = jsonInputString.concat(",\"stream\":true");

            }

            jsonInputString = jsonInputString.concat("}");

            byte[] jsonInputBytes = jsonInputString.getBytes(StandardCharsets.UTF_8);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.write(jsonInputBytes);
            out.flush();
            out.close();

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                if (!getStream()) {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    String id = jsonObject.getString("id");
                    String content = jsonObject.getJSONArray("choices").getJSONObject(0).getJSONObject("message")
                            .getString("content");
                    setRChatMessage(content);
                    setRID(id);
                    return content;
                } else {
                    return response.toString();
                }

            } else {
                return responseCode + "Error: HTTP response code " + "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString() + " ";
        }
    }

    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Chat chat = new Chat("gpt-3.5-turbo");
            chat.setApiKey("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");
            chat.setMessages(new Message("system", "Hello, how are you?", null));
            chat.setMessages(new Message("user", "Who are you?", null));
            chat.setFrequencyPenalty(1.0);
            chat.setPresencePenalty(1.0);
            chat.getResponse();
            System.out.println(chat.getRChatMessage());
        }
    }

}
