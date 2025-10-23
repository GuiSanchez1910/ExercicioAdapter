public class TikTokAdapter implements ISocialMediaAdapter {

    private final TikTokAPI api;

    public TikTokAdapter(TikTokAPI api) {
        this.api = api;
    }

    @Override
    public RespostaUnificada<Publicacao> postar(Conteudo conteudo) {
        try {
            String videoUrl = conteudo.getUrlImagem();
            
            if (videoUrl == null || videoUrl.isEmpty()) {
                return RespostaUnificada.erro("TikTok: Postagens requerem um vídeo.");
            }
            
            String description = conteudo.getTexto();

            TikTokUploadResult respostaTikTok = api.uploadVideo(videoUrl, description);

            Publicacao publicacao = new Publicacao(respostaTikTok.videoId, respostaTikTok.shareUrl);

            return RespostaUnificada.sucesso(publicacao);

        } catch (Exception e) {
            System.err.println("Erro ao postar no TikTok: " + e.getMessage());
            return RespostaUnificada.erro("TikTok: " + e.getMessage());
        }
    }
}