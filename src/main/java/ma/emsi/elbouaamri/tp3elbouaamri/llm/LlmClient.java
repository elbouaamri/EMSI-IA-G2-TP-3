package ma.emsi.elbouaamri.tp3elbouaamri.llm;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.data.message.SystemMessage;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class LlmClient {

    private String systemRole;
    private ChatMemory chatMemory;
    private GuideTouristique  guideTouristique;

    /** Constructeur : initialise le modèle Gemini et le service IA */
    public LlmClient() {

        String apiKey = System.getenv("GEMINI_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "Clé API manquante. Définissez GEMINI_KEY  dans vos variables d'environnement."
            );
        }

        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .temperature(0.7)
                .build();

        this.chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        this.guideTouristique = AiServices.builder(GuideTouristique .class)
                .chatModel(model)
                .chatMemory(chatMemory)
                .build();

    }


    /**
     * Envoie un prompt (question) au LLM et renvoie la réponse.
     */
    public InfosTouristiques  ask(String villeOuPays, int nb) {
        return guideTouristique.chat(villeOuPays, nb);
    }

}