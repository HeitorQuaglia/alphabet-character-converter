package com.overengineered.alphabet.exception;

import com.overengineered.alphabet.domain.AlphabetPosition;

public class AlphabetNotFoundException extends RuntimeException {
    private final AlphabetPosition position;

    public AlphabetNotFoundException(AlphabetPosition position) {
        super("No letter found for position: " + position.value());
        this.position = position;
    }

    public AlphabetPosition getPosition() {
        return position;
    }
}
