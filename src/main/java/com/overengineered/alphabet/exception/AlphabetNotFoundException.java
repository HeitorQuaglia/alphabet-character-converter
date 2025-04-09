package com.overengineered.alphabet.exception;

import com.overengineered.alphabet.domain.AlphabetPosition;

public class AlphabetNotFoundException extends RuntimeException {

    private final AlphabetPosition position;

    public AlphabetNotFoundException(AlphabetPosition position) {
        super();
        this.position = position;
    }

    public AlphabetPosition getPosition() {
        return position;
    }
}
