package com.overengineered.alphabet.application.service;

import com.overengineered.alphabet.domain.AlphabetCharacter;
import com.overengineered.alphabet.domain.AlphabetPosition;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ResolveAlphabetCharacterTest {

    private final ResolveAlphabetCharacter useCase = new ResolveAlphabetCharacter();

    @Test
    void shouldResolveCorrectCharacterForEachValidPosition() {
        IntStream.rangeClosed(1, 26).forEach(i -> {
            AlphabetPosition position = AlphabetPosition.from(i);
            AlphabetCharacter character = useCase.getCharacterByPosition(position);
            assertEquals((char) ('A' + i - 1), character.value());
        });
    }

    @Test
    void shouldReturnUppercaseLettersOnly() {
        AlphabetPosition position = AlphabetPosition.from(2);
        AlphabetCharacter character = useCase.getCharacterByPosition(position);

        assertEquals('B', character.value());
        assertEquals("B", character.asString());
    }
}
