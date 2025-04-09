package com.overengineered.alphabet.infrastructure.api.factory;

import jakarta.ws.rs.core.Response;

public final class ApiResponseFactory {

    private ApiResponseFactory() {
    }

    public static <T> Response ok(T body) {
        return Response.ok(body).build();
    }
}
