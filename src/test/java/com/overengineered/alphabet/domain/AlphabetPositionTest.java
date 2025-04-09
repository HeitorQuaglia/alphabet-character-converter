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
        assertThrows(IllegalArgumentException.class, () -> AlphabetPosition.from(0));
    }

    @Test
    void shouldRejectNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> AlphabetPosition.from(-1));
        assertThrows(IllegalArgumentException.class, () -> AlphabetPosition.from(-100));
    }

    @Test
    void shouldRejectValuesAbove26() {
        assertThrows(IllegalArgumentException.class, () -> AlphabetPosition.from(27));
        assertThrows(IllegalArgumentException.class, () -> AlphabetPosition.from(100));
    }

    @Test
    void shouldBeEqualForSamePosition() {
        AlphabetPosition a = AlphabetPosition.from(5);
        AlphabetPosition b = AlphabetPosition.from(5);

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void shouldNotBeEqualForDifferentPositions() {
        AlphabetPosition a = AlphabetPosition.from(1);
        AlphabetPosition b = AlphabetPosition.from(2);

        assertNotEquals(a, b);
    }

    @Test
    void shouldReturnCorrectValue() {
        AlphabetPosition position = AlphabetPosition.from(13);
        assertEquals(13, position.value());
    }

    @Test
    void toStringShouldContainValue() {
        AlphabetPosition position = AlphabetPosition.from(7);
        assertTrue(position.toString().contains("7"));
    }
}
