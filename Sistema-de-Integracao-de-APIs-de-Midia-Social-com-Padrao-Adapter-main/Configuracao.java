public class Configuracao {
    private String plataforma;
    private String apiKey;
    private String apiSecret;

    public Configuracao(String plataforma, String apiKey, String apiSecret) {
        this.plataforma = plataforma;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    public String getPlataforma() { return plataforma; }
    public String getApiKey() { return apiKey; }
    public String getApiSecret() { return apiSecret; }
}