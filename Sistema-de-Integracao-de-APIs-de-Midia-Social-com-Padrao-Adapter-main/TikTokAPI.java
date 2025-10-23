public class TikTokAPI {

    private String appKey;
    private String appSecret;

    public TikTokAPI(String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        System.out.println("TikTokAPI conectado com App Key: " + this.appKey.substring(0, 4) + "...");
    }

    public TikTokUploadResult uploadVideo(String videoFilePath, String description) throws Exception {
        if (videoFilePath == null || videoFilePath.isEmpty()) {
            throw new Exception("Caminho do vídeo é obrigatório para o TikTok.");
        }
        
        if (!videoFilePath.endsWith(".mp4")) {
             throw new Exception("Formato de vídeo inválido. TikTok aceita apenas .mp4.");
        }

        System.out.println("[TikTokAPI] Fazendo upload do vídeo: " + videoFilePath + " com descrição: '" + description + "'");

        String id = "tt_video_" + System.nanoTime();
        String shareUrl = "https://www.tiktok.com/@user/video/" + id;
        return new TikTokUploadResult(id, shareUrl);
    }
}