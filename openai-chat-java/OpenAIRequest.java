import java.util.ArrayList;

public abstract class OpenAIRequest {
    String apiKey;
    String model;
    String endpoint;
    String input;
    String instruction;
    int n=1;
    protected Double temperature;
    protected Double topP;
    protected boolean stream=false;
    protected int logprobs;
    protected boolean echo;
    protected String[] stop=null;
    protected Double presencePenalty=0.0;
    protected Double frequencyPenalty=0.0;
    protected int bestOf;
    protected String user;
    protected String prompt;
    protected String size;
    protected String responseFormat;
    protected int maxTokens=100;
    protected String system_message;
    protected String[] ai_message;
    protected String[] user_message;
    protected String image;
    String mask;
    ArrayList<Message> messages=new ArrayList<Message>();
    
    
    String rID;
    String rChatMessage;
    String rFinishReason;
    String rFullString;
    
    public OpenAIRequest(){
    }

    public OpenAIRequest(String model){
        this.model = model;
    }

    public void setInput(String input){
        this.input = input;
    }

    public void setInstruction(String instruction){
        this.instruction = instruction;
    }

    public void setN(int n){
        this.n = n;
    }

    public void setTemperature(Double temperature){
        this.temperature = temperature;
    }

    public void setTopP(Double topP){
        this.topP = topP;
    }

    public void setStream(boolean stream){
        this.stream = stream;
    }

    public void setLogprobs(int logprobs){
        this.logprobs = logprobs;
    }

    public void setEcho(boolean echo){
        this.echo = echo;
    }

    public void setStop(String[] stop){
        this.stop = stop;
    }

    public void setPresencePenalty(Double presencePenalty){
        this.presencePenalty = presencePenalty;
    }

    public void setFrequencyPenalty(Double frequencyPenalty){
        this.frequencyPenalty = frequencyPenalty;
    }

    public void setBestOf(int bestOf){
        this.bestOf = bestOf;
    }

    public void setUser(String user){
        this.user = user;
    }

    public void setPrompt(String prompt){
        this.prompt = prompt;
    }

    public void setSize(String size){
        this.size = size;
    }

    public void setResponseFormat(String responseFormat){
        this.responseFormat = responseFormat;
    }

    public void setMaxTokens(int maxTokens){
        this.maxTokens = maxTokens;
    }

    public void setImage(String image){
        this.image = image;
    }

    public void setMask(String mask){
        this.mask = mask;
    }

    public String getInput(){
        return input;
    }

    public String getInstruction(){
        return instruction;
    }

    public int getN(){
        return n;
    }

    public Double getTemperature(){
        return temperature;
    }

    public Double getTopP(){
        return topP;
    }

    public boolean getStream(){
        return stream;
    }

    public int getLogprobs(){
        return logprobs;
    }

    public boolean getEcho(){
        return echo;
    }

    public String[] getStop(){
        return stop;
    }

    public Double getPresencePenalty(){
        return presencePenalty;
    }

    public Double getFrequencyPenalty(){
        return frequencyPenalty;
    }

    public int getBestOf(){
        return bestOf;
    }

    public String getUser(){
        return user;
    }

    public String getPrompt(){
        return prompt;
    }

    public String getSize(){
        return size;
    }

    public String getResponseFormat(){
        return responseFormat;
    }

    public int getMaxTokens(){
        return maxTokens;
    }

    public String getImage(){
        return image;
    }

    public String getMask(){
        return mask;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getModel(){
        return model;
    }

    public void setEndPoint(String endpoint){
        this.endpoint = endpoint;
    }

    public String getEndPoint(){
        return endpoint;
    }

    public void setApiKey(String apiKey){
        this.apiKey = apiKey;
    }

    public String getApiKey(){
        return apiKey;
    }

    public void setSystemMessage(String system_message){
        this.system_message = system_message;
    }

    public String getSystemMessage(){
        return system_message;
    }

    public void setAiMessage(String[] ai_message){
        this.ai_message = ai_message;
    }

    public String[] getAiMessage(){
        return ai_message;
    }
    public void setUserMessage(String[] user_message){
        this.user_message = user_message;
    }

    public String[] getUserMessage(){
        return user_message;
    }

    public void setMessages(Message messages){
        this.messages.add(messages);
    }
    public void setMessages(ArrayList<Message> message){
        for (Message msg : message) {
            this.messages.add(msg);
        }
    }
    public ArrayList<Message> getMessages(){
        return messages;
    }

    public String getResponse(){
        return "null";
    }

    public void setRID(String rID){
        this.rID = rID;
    }

    public String getRID(){
        return rID;
    }

    public void setRChatMessage(String rChatMessage){
        this.rChatMessage = rChatMessage;
    }

    public String getRChatMessage(){
        return rChatMessage;
    }

    public void setRFinishReason(String rFinishReason){
        this.rFinishReason = rFinishReason;
    }

    public String getRFinishReason(){
        return rFinishReason;
    }

    public void setRFullChat(String rFullString){
        this.rFullString = rFullString;
    }

    public String getRFullChat(){
        return rFullString;
    }
    public static void main(String[] args) {
        Message[] messages = new Message[2];
        messages[0] = new Message("user", "Hi", "Bob");
        messages[1] = new Message("ai", "assistant", "");
        for (Message message : messages) {
            System.out.println(message);
        }

        
        
    }



    
}


