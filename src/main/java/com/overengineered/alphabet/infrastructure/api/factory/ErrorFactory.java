package com.overengineered.alphabet.infrastructure.api.factory;

import com.overengineered.alphabet.domain.AlphabetPosition;

public final class ErrorFactory {

    private ErrorFactory() {
        // Evita instanciamento
    }

    public static ErrorResponse invalidPosition(int value) {
        return new ErrorResponse("Invalid position: " + value + ". Must be between 1 and 26.");
    }

    public static ErrorResponse fromException(Exception exception) {
        return new ErrorResponse(exception.getMessage());
    }

    public static ErrorResponse fromInvalidPosition(AlphabetPosition position) {
        return new ErrorResponse("Position not found: " + position.value());
    }

    public record ErrorResponse(String error) {}
}
