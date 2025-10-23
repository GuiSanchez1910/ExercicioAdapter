public class Conteudo {
    private String texto;
    private String urlImagem;

    public Conteudo(String texto, String urlImagem) {
        this.texto = texto;
        this.urlImagem = urlImagem;
    }

    public String getTexto() { return texto; }
    public String getUrlImagem() { return urlImagem; }
}