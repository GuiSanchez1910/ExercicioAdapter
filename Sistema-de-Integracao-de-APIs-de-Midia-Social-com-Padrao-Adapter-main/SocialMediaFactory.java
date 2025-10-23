public class SocialMediaFactory {

    public static ISocialMediaAdapter criarAdaptador(Configuracao config) {
        
        switch (config.getPlataforma().toLowerCase()) {
            
            case "twitter":
                TwitterAPI twitterApi = new TwitterAPI(config.getApiKey());
                return new TwitterAdapter(twitterApi);
                
            case "linkedin":
                LinkedInAPI linkedInApi = new LinkedInAPI(config.getApiKey(), config.getApiSecret());
                return new LinkedInAdapter(linkedInApi);

            case "instagram":
                InstagramAPI instaApi = new InstagramAPI(config.getApiKey());
                return new InstagramAdapter(instaApi);

            case "tiktok":
                TikTokAPI tikTokApi = new TikTokAPI(config.getApiKey(), config.getApiSecret());
                return new TikTokAdapter(tikTokApi);
                
            default:
                throw new IllegalArgumentException("Plataforma não suportada: " + config.getPlataforma());
        }
    }
}