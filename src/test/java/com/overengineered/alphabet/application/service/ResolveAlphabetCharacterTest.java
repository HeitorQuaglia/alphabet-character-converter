package com.overengineered.alphabet.application.service;

import com.overengineered.alphabet.domain.AlphabetCharacter;
import com.overengineered.alphabet.domain.AlphabetPosition;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ResolveAlphabetCharacterTest {

    private final ResolveAlphabetCharacter useCase = new ResolveAlphabetCharacter();

    @Test
    void shouldResolveCharacterForValidPositions() {
        IntStream.rangeClosed(1, 26).forEach(pos -> {
            AlphabetPosition position = AlphabetPosition.from(pos);
            AlphabetCharacter character = useCase.getCharacterByPosition(position);
            assertEquals((char) ('A' + pos - 1), character.value());
        });
    }
}
