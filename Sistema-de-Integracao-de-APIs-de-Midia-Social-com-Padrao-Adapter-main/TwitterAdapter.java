public class TwitterAdapter implements ISocialMediaAdapter {

    private final TwitterAPI api;

    public TwitterAdapter(TwitterAPI api) {
        this.api = api;
    }

    @Override
    public RespostaUnificada<Publicacao> postar(Conteudo conteudo) {
        try {
            String tweetText = conteudo.getTexto();
            
            TweetResponse respostaTwitter = api.postTweet(tweetText);

            Publicacao publicacao = new Publicacao(respostaTwitter.tweetId, respostaTwitter.tweetUrl);

            return RespostaUnificada.sucesso(publicacao);
            
        } catch (Exception e) {
            System.err.println("Erro ao postar no Twitter: " + e.getMessage());
            return RespostaUnificada.erro("Twitter: " + e.getMessage());
        }
    }
}