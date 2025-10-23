public class InstagramPostResponse {
    public final String postId;
    public final String permalink;

    public InstagramPostResponse(String postId, String permalink) {
        this.postId = postId;
        this.permalink = permalink;
    }
}