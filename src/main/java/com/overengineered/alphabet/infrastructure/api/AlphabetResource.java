package com.overengineered.alphabet.infrastructure.api;

import com.overengineered.alphabet.application.service.AlphabetService;
import com.overengineered.alphabet.domain.AlphabetCharacter;
import com.overengineered.alphabet.domain.AlphabetPosition;
import com.overengineered.alphabet.exception.AlphabetNotFoundException;
import com.overengineered.alphabet.infrastructure.api.factory.ApiResponseFactory;
import com.overengineered.alphabet.infrastructure.api.factory.ErrorFactory;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/alphabet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlphabetResource {

    @Inject
    AlphabetService alphabetService;

    @GET
    @Path("/{position}")
    public Response getLetter(@PathParam("position") int position) {
        try {
            AlphabetPosition alphabetPosition = AlphabetPosition.from(position);
            AlphabetCharacter character = alphabetService.getCharacterByPosition(alphabetPosition);
            return ApiResponseFactory.ok(new AlphabetResponse(character.asString()));
        } catch (IllegalArgumentException ex) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(ErrorFactory.invalidPosition(position))
                    .build();

        } catch (AlphabetNotFoundException ex) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(ErrorFactory.fromInvalidPosition(ex.getPosition()))
                    .build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ErrorFactory.fromException(ex))
                    .build();
        }
    }

    public record AlphabetResponse(String letter) {}
}
