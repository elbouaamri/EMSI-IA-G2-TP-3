Compte rendu — TP3 : API REST et intégration d’IA avec Gemini

Pour ce TP, j’ai développé une application REST utilisant Jakarta EE (JAX-RS) afin de créer un service capable de générer des recommandations personnalisées grâce à un modèle d’intelligence artificielle (Gemini) via LangChain4j. L’objectif était de me familiariser avec la création d’API REST et l’intégration d’une IA pour produire des réponses dynamiques.

Pour diversifier le projet, j’ai imaginé un scénario différent : l’application propose maintenant des suggestions d’activités locales selon une ville donnée. L’API expose un endpoint :
/api/activites/ville/{nomVille}?nb=

qui renvoie, au format JSON, une liste d’activités intéressantes et le budget moyen nécessaire pour les réaliser. L’utilisateur peut choisir combien d’activités il souhaite obtenir en utilisant le paramètre ?nb=.

Exemple de requête :
http://localhost:8080/tp3-activites-1.0-SNAPSHOT/api/activites/ville/Lyon?nb=4

Exemple de réponse JSON :

{
"lieu": "Paris",
"endroitsAVisiter": [
"Tour Eiffel",
"Musée du Louvre",
"Cathédrale Notre-Dame de Paris"
],
"prixMoyenRepas": "18 EUR"
}

Pour structurer l’application :

La classe LlmClient s’occupe de communiquer avec Gemini via LangChain4j.

Une interface ActiviteService et un record ActiviteInfos permettent d’organiser les données JSON renvoyées.

L’API prend en charge les paramètres dynamiques pour adapter le nombre d’activités selon la demande.

Grâce à ce TP, j’ai pu :

Mettre en place et déployer une API REST en Jakarta EE.

Connecter un modèle d’IA générative (Gemini) à un service web.

Produire des réponses JSON structurées et dynamiques.

Gérer des paramètres pour rendre l’API flexible et personnalisable.

ℹ️ Remarque : la dépendance langchain4j-easy-rag a été ajoutée par erreur dans un premier temps, puis retirée, car elle n’était pas nécessaire pour ce TP.