import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GerenciadorMidiaSocial {

    private final Map<String, ISocialMediaAdapter> adaptadores;

    public GerenciadorMidiaSocial() {
        this.adaptadores = new ConcurrentHashMap<>();
    }

    public void adicionarPlataforma(Configuracao config) {
        try {
            ISocialMediaAdapter adaptador = SocialMediaFactory.criarAdaptador(config);
            this.adaptadores.put(config.getPlataforma().toLowerCase(), adaptador);
            System.out.println("Plataforma '" + config.getPlataforma() + "' configurada com sucesso.");
        } catch (Exception e) {
            System.err.println("Falha ao configurar plataforma '" + config.getPlataforma() + "': " + e.getMessage());
        }
    }

    public void agendarPublicacao(String plataforma, Conteudo conteudo) {
        ISocialMediaAdapter adaptador = adaptadores.get(plataforma.toLowerCase());

        if (adaptador == null) {
            System.err.println("Tentativa de postar em plataforma não configurada: " + plataforma);
            return;
        }

        System.out.println("\n--- Agendando post para: " + plataforma.toUpperCase() + " ---");
        
        RespostaUnificada<Publicacao> resposta = adaptador.postar(conteudo);

        if (resposta.isSucesso()) {
            System.out.println("[Sucesso] Publicação realizada!");
            System.out.println(resposta.getDados());
        } else {
            System.out.println("[Falha] Não foi possível publicar:");
            System.out.println(resposta.getErro());
        }
    }
}