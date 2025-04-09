package com.overengineered.alphabet.domain;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetPositionTest {

    @Test
    void shouldCreateValidPositions() {
        IntStream.rangeClosed(1, 26).forEach(i -> {
            AlphabetPosition position = AlphabetPosition.from(i);
            assertEquals(i, position.value());
        });
    }

    @Test
    void shouldRejectZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> AlphabetPosition.from(0)
        );
        assertTrue(exception.getMessage().contains("between 1 and 26"));
    }

    @Test
    void shouldRejectNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> AlphabetPosition.from(-5));
    }

    @Test
    void shouldRejectValuesAbove26() {
        assertThrows(IllegalArgumentException.class, () -> AlphabetPosition.from(100));
    }

    @Test
    void shouldBeEqualForSamePosition() {
        AlphabetPosition pos1 = AlphabetPosition.from(13);
        AlphabetPosition pos2 = AlphabetPosition.from(13);

        assertEquals(pos1, pos2);
        assertEquals(pos1.hashCode(), pos2.hashCode());
    }

    @Test
    void shouldNotBeEqualForDifferentPositions() {
        AlphabetPosition pos1 = AlphabetPosition.from(1);
        AlphabetPosition pos2 = AlphabetPosition.from(2);

        assertNotEquals(pos1, pos2);
    }
}
