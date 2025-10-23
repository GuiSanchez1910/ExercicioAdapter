public class Main {
    public static void main(String[] args) {
        
        System.out.println("Iniciando Sistema de Gerenciamento de Mídia Social...");

        GerenciadorMidiaSocial gerenciador = new GerenciadorMidiaSocial();

        Configuracao configTwitter = new Configuracao(
            "twitter", 
            "TW_API_KEY_12345", 
            "TW_API_SECRET_67890"
        );
        Configuracao configLinkedIn = new Configuracao(
            "linkedin", 
            "LI_CLIENT_ID_ABCDE", 
            "LI_CLIENT_SECRET_FGHIJ"
        );
        Configuracao configInstagram = new Configuracao(
            "instagram",
            "IG_ACCESS_TOKEN_LONG_LIVED_654321",
            null
        );
        Configuracao configTikTok = new Configuracao(
            "tiktok",
            "TT_APP_KEY_ABC123",
            "TT_APP_SECRET_DEF456"
        );

        gerenciador.adicionarPlataforma(configTwitter);
        gerenciador.adicionarPlataforma(configLinkedIn);
        gerenciador.adicionarPlataforma(configInstagram);
        gerenciador.adicionarPlataforma(configTikTok);

        Conteudo postSimples = new Conteudo(
            "Olá mundo! Este é meu primeiro post unificado!", 
            null
        );

        Conteudo postComImagem = new Conteudo(
            "Confira nossa nova vaga de Desenvolvedor Java Sr. #Java #DesignPatterns", 
            "https://example.com/images/vaga.jpg"
        );
        
        Conteudo postComVideo = new Conteudo(
            "Nova trend de dança! #devlife #adapterpattern",
            "https://example.com/videos/minha_danca.mp4"
        );

        System.out.println("\n===== INICIANDO TESTES DE SUCESSO =====");
        gerenciador.agendarPublicacao("twitter", postSimples);
        gerenciador.agendarPublicacao("linkedin", postComImagem);
        gerenciador.agendarPublicacao("instagram", postComImagem);
        gerenciador.agendarPublicacao("tiktok", postComVideo);

        System.out.println("\n===== INICIANDO TESTES DE FALHA =====");
        
        gerenciador.agendarPublicacao("instagram", postSimples); 
        
        gerenciador.agendarPublicacao("tiktok", postComImagem);
        
        String textoLongo = "Este texto é muito, muito, muito longo. " + 
                            "Ele foi desenhado especificamente para falhar na API do Twitter, " + 
                            "que possui uma restrição de apenas 280 caracteres. " +
                            "Vamos continuar escrevendo até ter certeza absoluta de que passamos desse limite. " +
                            "O padrão Adapter é ótimo para lidar com essas falhas de forma unificada, " +
                            "capturando a exceção da API específica e traduzindo-a para a nossa RespostaUnificada de erro. " +
                            "Quase lá... só mais um pouco... pronto!";
        
        Conteudo postLongo = new Conteudo(textoLongo, null);
        gerenciador.agendarPublicacao("twitter", postLongo);
    }
}