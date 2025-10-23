public class InstagramAPI {

    private String accessToken;

    public InstagramAPI(String accessToken) {
        this.accessToken = accessToken;
        System.out.println("InstagramAPI conectado com Access Token.");
    }

    public InstagramPostResponse publishPhoto(String imageUrl, String caption) throws Exception {
        
        if (this.accessToken == null || this.accessToken.isEmpty()) {
            throw new Exception("Access Token inválido ou não fornecido.");
        }

        if (imageUrl == null || imageUrl.isEmpty()) {
            throw new Exception("URL da imagem é obrigatória para o Instagram.");
        }

        System.out.println("[InstagramAPI] Publicando foto: " + imageUrl + " com legenda: '" + caption + "'");

        String id = "ig_post_" + System.nanoTime();
        String permalink = "https://instagram.com/p/" + id;
        return new InstagramPostResponse(id, permalink);
    }
}