public class LinkedInAPI {

    private String clientId;
    private String clientSecret;

    public LinkedInAPI(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        System.out.println("LinkedInAPI conectado com o Client ID: " + this.clientId.substring(0, 4) + "...");
    }

    public String sharePost(LinkedInPostData postData) {
        if (postData == null || postData.content == null) {
            throw new IllegalArgumentException("Dados do post inválidos para o LinkedIn.");
        }

        System.out.println("[LinkedInAPI] Compartilhando do autor " + postData.authorUrn + ": '" + postData.content + "'");
        
        String id = "li_share_" + System.nanoTime();
        return "https://www.linkedin.com/feed/update/" + id;
    }
}