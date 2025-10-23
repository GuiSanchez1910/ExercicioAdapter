public class InstagramAdapter implements ISocialMediaAdapter {

    private final InstagramAPI api;

    public InstagramAdapter(InstagramAPI api) {
        this.api = api;
    }

    @Override
    public RespostaUnificada<Publicacao> postar(Conteudo conteudo) {
        try {          
            String imageUrl = conteudo.getUrlImagem();
            if (imageUrl == null || imageUrl.isEmpty()) {
                return RespostaUnificada.erro("Instagram: Postagens requerem uma imagem.");
            }
            
            String caption = conteudo.getTexto();

            InstagramPostResponse respostaInsta = api.publishPhoto(imageUrl, caption);

            Publicacao publicacao = new Publicacao(respostaInsta.postId, respostaInsta.permalink);

            return RespostaUnificada.sucesso(publicacao);

        } catch (Exception e) {
            System.err.println("Erro ao postar no Instagram: " + e.getMessage());
            return RespostaUnificada.erro("Instagram: " + e.getMessage());
        }
    }
}