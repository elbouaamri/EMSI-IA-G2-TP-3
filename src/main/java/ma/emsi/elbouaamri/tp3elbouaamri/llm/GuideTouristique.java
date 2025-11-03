package ma.emsi.elbouaamri.tp3elbouaamri.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface GuideTouristique  {
    @SystemMessage("""
        Tu es un guide touristique. Réponds STRICTEMENT au schéma demandé.
        N'ajoute aucun texte hors JSON, n'utilise pas Markdown.
        """)
    @UserMessage("""
        Donne les informations structurées pour {{lieu}} avec un format JSON.
        Contraintes :
        - "prix_moyen_repas" est une courte chaîne avec devise (ex. "18 EUR").
        - "endroits_a_visiter" contient les {{nb}} principaux endroits à visiter dans {{lieu}}.
        """)
    InfosTouristiques chat(@V("lieu") String lieu, @V("nb") int nbAVisiter);

}
