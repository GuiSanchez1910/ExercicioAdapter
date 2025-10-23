public class TikTokUploadResult {
    public final String videoId;
    public final String shareUrl;
    public final int status_code;

    public TikTokUploadResult(String videoId, String shareUrl) {
        this.videoId = videoId;
        this.shareUrl = shareUrl;
        this.status_code = 0;
    }
}