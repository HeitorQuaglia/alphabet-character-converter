package com.overengineered.alphabet.infrastructure.api;

import com.overengineered.alphabet.application.service.AlphabetService;
import com.overengineered.alphabet.domain.AlphabetCharacter;
import com.overengineered.alphabet.domain.AlphabetPosition;
import com.overengineered.alphabet.exception.AlphabetNotFoundException;
import com.overengineered.alphabet.exception.InvalidLetterException;
import com.overengineered.alphabet.exception.LetterOutOfRangeException;
import com.overengineered.alphabet.infrastructure.api.factory.ApiResponseFactory;
import com.overengineered.alphabet.infrastructure.i18n.MessageProvider;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Locale;

@Path("/alphabet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlphabetResource {

    @Inject
    AlphabetService alphabetService;

    @Inject
    MessageProvider messageProvider;

    @GET
    @Path("/{position}")
    public Response getLetter(
            @PathParam("position") int position,
            @HeaderParam("Accept-Language") @DefaultValue("en") String language
    ) {
        Locale locale = Locale.forLanguageTag(language);

        try {
            AlphabetPosition alphabetPosition = AlphabetPosition.from(position);
            AlphabetCharacter character = alphabetService.getCharacterByPosition(alphabetPosition);
            return ApiResponseFactory.ok(new AlphabetResponse(character.asString()));

        } catch (AlphabetNotFoundException ex) {
            String msg = messageProvider.get("position.not.found", locale, ex.getPosition().value());
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse(msg)).build();

        } catch (InvalidLetterException ex) {
            String msg = messageProvider.get("letter.invalid", locale);
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse(msg)).build();

        } catch (LetterOutOfRangeException ex) {
            String msg = messageProvider.get("letter.range", locale);
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse(msg)).build();

        } catch (IllegalArgumentException ex) {
            String msg = messageProvider.get("invalid.position", locale, position);
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse(msg)).build();
        }
    }

    public record AlphabetResponse(String letter) {}
    public record ErrorResponse(String error) {}
}
