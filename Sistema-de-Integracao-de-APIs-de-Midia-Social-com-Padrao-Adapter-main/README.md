# Projeto: Sistema de Integração de Mídias Sociais (Padrão Adapter)

Este projeto é uma implementação em Java de um sistema de gerenciamento de mídias sociais, desenvolvido como um exercício prático sobre Padrões de Projeto (Design Patterns).

## 1. Objetivo do Sistema

O objetivo principal é criar um sistema unificado (um "Gerenciador") capaz de postar conteúdo em múltiplas plataformas de mídia social (Twitter, LinkedIn, Instagram e TikTok).

O desafio central é que cada plataforma possui uma API completamente diferente, com métodos, modelos de dados e regras de negócio incompatíveis (ex: Twitter tem limite de 280 caracteres, Instagram exige uma foto, TikTok exige um vídeo).

## 2. Padrões de Projeto Utilizados

Para resolver a incompatibilidade das APIs, uma arquitetura flexível foi criada usando uma combinação de padrões de projeto:

### a. Padrão Adapter (Adaptador)
* **Propósito:** É o padrão principal do projeto. Ele "traduz" a interface de uma classe (a API Externa) para uma interface unificada que o nosso sistema espera (a `ISocialMediaAdapter`).
* **Implementação:** Para cada API (`TwitterAPI`, `LinkedInAPI`, etc.), foi criado um `Adapter` correspondente (`TwitterAdapter`, `LinkedInAdapter`, etc.). Cada adaptador implementa a nossa interface `ISocialMediaAdapter` e, internamente (usando **composição**), segura uma instância da API real. Quando o método unificado `postar(Conteudo)` é chamado, o adaptador traduz essa chamada para o método específico da API (ex: `api.postTweet(...)`).

### b. Padrão Factory (Simple Factory)
* **Propósito:** Centralizar e desacoplar a lógica de criação dos adaptadores. O nosso sistema cliente (`GerenciadorMidiaSocial`) não deve saber *como* construir um `TwitterAdapter` (que precisa de uma `apiKey`, por exemplo).
* **Implementação:** A classe `SocialMediaFactory` possui um método estático `criarAdaptador(Configuracao)`. Baseado na configuração recebida, a fábrica instancia a API correta com as credenciais corretas e a "embrulha" no adaptador correspondente, devolvendo a instância pronta para uso.

### c. Padrão Strategy (Estratégia)
* **Propósito:** Permitir que o algoritmo (a forma de postar) seja selecionado em tempo de execução.
* **Implementação:** A interface `ISocialMediaAdapter` atua como a *Strategy* (a interface da estratégia). O `GerenciadorMidiaSocial` (o *Contexto*) mantém um mapa de estratégias disponíveis (`Map<String, ISocialMediaAdapter>`). Quando o usuário pede para `agendarPublicacao("twitter", ...)`, o gerenciador seleciona a estratégia (adaptador) correta do mapa e a executa, sem nunca saber qual é a implementação concreta.

## 3. Como Compilar e Executar

O projeto foi escrito sem pacotes (packages) para simplificar a compilação. Todos os ficheiros `.java` devem estar no mesmo diretório.

**1. Compilar (pelo terminal):**
Navegue até a pasta do projeto e execute:
```bash
javac *.java
