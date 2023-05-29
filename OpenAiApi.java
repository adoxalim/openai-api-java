
public abstract class OpenAiApi {

    protected String prompt;
    protected int max_tokens;
    protected double temperature;
    protected String model;
    protected String endpoint;
    protected String apiKey;
    protected String input;
    protected String file;
    protected String messages;
    protected String stop;
    protected String suffix;
    protected double top_p;
    protected int n;
    protected int logprobs;
    protected int echo;
    protected int presence_penalty;
    protected int frequency_penalty;
    protected int best_of;
    protected String stream;
    protected String logprobsFile;
    protected String expand;
    protected String logit_biasFile;
    protected String stopSequences;
    protected String mask;
    protected String instruction;
    protected String size;
    protected String user;
    protected String content;
    protected String response_format;


    public OpenAiApi(String endpoint, String apiKey, String prompt, int max_tokens, String model) {
        this.prompt = prompt;
        this.max_tokens = max_tokens;
        this.model = model;
        this.endpoint = endpoint;
        this.apiKey = apiKey;
    }

    public OpenAiApi(String endpoint, String apiKey) {
        this.endpoint = endpoint;
        this.apiKey = apiKey;
    }
    
    public OpenAiApi(String endpoint, String apiKey, String model, String file) {
        this.endpoint = endpoint;
        this.apiKey = apiKey;
        this.model = model;
        this.file = file;
    }

    public OpenAiApi(String endpoint, String apiKey, String model, String input, String instruction) {
        this.endpoint = endpoint;
        this.apiKey = apiKey;
        this.model = model;
        this.input = input;
        this.instruction = instruction;
    }

    public OpenAiApi(String endpoint, String apiKey, String model, String input, String instruction, String stop) {
        this.endpoint = endpoint;
        this.apiKey = apiKey;
        this.model = model;
        this.input = input;
        this.instruction = instruction;
        this.stop = stop;
    }
    public String getPrompt() {
        return prompt;
    }

    public int getMax_tokens() {
        return max_tokens;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getModel() {
        return model;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getMessages() {
        return messages;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getStop() {
        return stop;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setTop_p(double top_p) {
        this.top_p = top_p;
    }

    public double getTop_p() {
        return top_p;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setLogprobs(int logprobs) {
        this.logprobs = logprobs;
    }

    public int getLogprobs() {
        return logprobs;
    }

    public void setEcho(int echo) {
        this.echo = echo;
    }

    public int getEcho() {
        return echo;
    }

    public void setPresence_penalty(int presence_penalty) {
        this.presence_penalty = presence_penalty;
    }

    public int getPresence_penalty() {
        return presence_penalty;
    }

    public void setFrequency_penalty(int frequency_penalty) {
        this.frequency_penalty = frequency_penalty;
    }

    public int getFrequency_penalty() {
        return frequency_penalty;
    }

    public void setBest_of(int best_of) {
        this.best_of = best_of;
    }

    public int getBest_of() {
        return best_of;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getStream() {
        return stream;
    }

    public void setLogprobsFile(String logprobsFile) {
        this.logprobsFile = logprobsFile;
    }

    public String getLogprobsFile() {
        return logprobsFile;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public String getExpand() {
        return expand;
    }

    public void setStopSequences(String stopSequences) {
        this.stopSequences = stopSequences;
    }

    public String getStopSequences() {
        return stopSequences;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getMask() {
        return mask;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setMax_tokens(int max_tokens) {
        this.max_tokens = max_tokens;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }
    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    public void setResponse_format(String response_format) {
        this.response_format = response_format;
    }

    public String getResponse_format() {
        return response_format;
    }

    @Override
    public String toString() {
        return "";
    }
}