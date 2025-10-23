
public class TwitterAPI {

    private String apiKey;

    public TwitterAPI(String apiKey) {
        this.apiKey = apiKey;
        System.out.println("TwitterAPI conectado com a chave: " + this.apiKey.substring(0, 4) + "...");
    }

    // Método específico do Twitter
    public TweetResponse postTweet(String text) throws Exception {
        if (text == null || text.isEmpty()) {
            throw new Exception("Tweet não pode ser vazio.");
        }
        if (text.length() > 280) {
            throw new Exception("Tweet excede 280 caracteres.");
        }
        
        System.out.println("[TwitterAPI] Postando: '" + text + "'");
        
        String id = "tw_" + System.nanoTime();
        String url = "https://twitter.com/user/status/" + id;
        return new TweetResponse(id, url);
    }
}