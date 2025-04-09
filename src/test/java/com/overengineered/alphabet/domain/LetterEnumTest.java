package com.overengineered.alphabet.domain;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LetterEnumTest {

    @Test
    void shouldReturnEnumForValidPositions() {
        IntStream.rangeClosed(1, 26).forEach(pos -> {
            Optional<LetterEnum> result = LetterEnum.fromPosition(pos);
            assertTrue(result.isPresent(), "Expected letter for position: " + pos);
            assertEquals(pos, result.get().position());
        });
    }

    @Test
    void shouldReturnEmptyForInvalidPositions() {
        assertTrue(LetterEnum.fromPosition(0).isEmpty());
        assertTrue(LetterEnum.fromPosition(27).isEmpty());
        assertTrue(LetterEnum.fromPosition(-5).isEmpty());
        assertTrue(LetterEnum.fromPosition(100).isEmpty());
    }

    @Test
    void shouldConvertToAlphabetCharacterCorrectly() {
        LetterEnum letter = LetterEnum.C;
        AlphabetCharacter character = letter.toAlphabetCharacter();

        assertEquals('C', character.value());
        assertEquals(3, letter.position());
    }

    @Test
    void shouldHaveCorrectPositionForAllLetters() {
        int expected = 1;
        for (LetterEnum letter : LetterEnum.values()) {
            assertEquals(expected++, letter.position());
        }
    }
}
