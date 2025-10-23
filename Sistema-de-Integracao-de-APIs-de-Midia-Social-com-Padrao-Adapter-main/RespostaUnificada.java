public class RespostaUnificada<T> {
    private final T dados;
    private final String erro;
    private final boolean sucesso;

    private RespostaUnificada(T dados) {
        this.dados = dados;
        this.erro = null;
        this.sucesso = true;
    }

    private RespostaUnificada(String erro) {
        this.dados = null;
        this.erro = erro;
        this.sucesso = false;
    }

    public static <T> RespostaUnificada<T> sucesso(T dados) {
        return new RespostaUnificada<>(dados);
    }

    public static <T> RespostaUnificada<T> erro(String mensagem) {
        return new RespostaUnificada<>(mensagem);
    }

    public boolean isSucesso() { return sucesso; }
    public T getDados() {
        if (!sucesso) {
            throw new IllegalStateException("Tentativa de acessar dados de uma resposta de erro.");
        }
        return dados;
    }
    public String getErro() {
        if (sucesso) {
            throw new IllegalStateException("Tentativa de acessar erro de uma resposta de sucesso.");
        }
        return erro;
    }
}