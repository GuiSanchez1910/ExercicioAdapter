public class Publicacao {
    private String idPost;
    private String urlPost;
    private long timestamp;

    public Publicacao(String idPost, String urlPost) {
        this.idPost = idPost;
        this.urlPost = urlPost;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Publicacao [id=" + idPost + ", url=" + urlPost + ", timestamp=" + timestamp + "]";
    }
}