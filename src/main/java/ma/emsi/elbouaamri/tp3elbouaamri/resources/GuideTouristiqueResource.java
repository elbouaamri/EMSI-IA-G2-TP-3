package ma.emsi.elbouaamri.tp3elbouaamri.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.emsi.elbouaamri.tp3elbouaamri.llm.InfosTouristiques;
import ma.emsi.elbouaamri.tp3elbouaamri.llm.LlmClient;

@Path("/guide")
public class GuideTouristiqueResource {
    @Inject
    private LlmClient llm;


    @GET
    @Path("/lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLieu(@PathParam("ville_ou_pays") String lieu,
                            @QueryParam("nb") @DefaultValue("2") int nb) {
        InfosTouristiques reponse = llm.ask(lieu, nb);
        return Response.ok(reponse).build();    }
}
// bonjour mr Grin je fais ça par ce que j'ai le message du commite n'est pas bien modifié
