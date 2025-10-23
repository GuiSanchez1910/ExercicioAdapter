public class LinkedInAdapter implements ISocialMediaAdapter {

    private final LinkedInAPI api;
    private static final String DEFAULT_AUTHOR_URN = "urn:li:person:12345678";


    public LinkedInAdapter(LinkedInAPI api) {
        this.api = api;
    }

    @Override
    public RespostaUnificada<Publicacao> postar(Conteudo conteudo) {
        try {
            LinkedInPostData postData = new LinkedInPostData(
                DEFAULT_AUTHOR_URN,
                conteudo.getTexto(),
                conteudo.getUrlImagem() 
            );

            String urlPostagem = api.sharePost(postData);

            Publicacao publicacao = new Publicacao(urlPostagem, urlPostagem);

            return RespostaUnificada.sucesso(publicacao);

        } catch (Exception e) {
            System.err.println("Erro ao postar no LinkedIn: " + e.getMessage());
            return RespostaUnificada.erro("LinkedIn: " + e.getMessage());
        }
    }
}