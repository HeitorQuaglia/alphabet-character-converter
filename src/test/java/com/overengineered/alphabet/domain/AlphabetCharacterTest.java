package com.overengineered.alphabet.domain;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetCharacterTest {

    @Test
    void shouldCreateCharactersFromValidLetters() {
        IntStream.rangeClosed('A', 'Z').forEach(codePoint -> {
            char lower = Character.toLowerCase((char) codePoint);
            AlphabetCharacter ch = AlphabetCharacter.from(lower);
            assertEquals((char) codePoint, ch.value());
        });
    }

    @Test
    void shouldRejectNonLetterCharacters() {
        assertThrows(IllegalArgumentException.class, () -> AlphabetCharacter.from('1'));
        assertThrows(IllegalArgumentException.class, () -> AlphabetCharacter.from('-'));
        assertThrows(IllegalArgumentException.class, () -> AlphabetCharacter.from('@'));
    }

    @Test
    void shouldConvertToUpperCaseAutomatically() {
        AlphabetCharacter ch = AlphabetCharacter.from('b');
        assertEquals('B', ch.value());
    }

    @Test
    void shouldBeEqualForSameLetter() {
        AlphabetCharacter a1 = AlphabetCharacter.from('A');
        AlphabetCharacter a2 = AlphabetCharacter.from('a');

        assertEquals(a1, a2);
        assertEquals(a1.hashCode(), a2.hashCode());
    }

    @Test
    void shouldNotBeEqualForDifferentLetters() {
        AlphabetCharacter a = AlphabetCharacter.from('A');
        AlphabetCharacter b = AlphabetCharacter.from('B');

        assertNotEquals(a, b);
    }

    @Test
    void shouldReturnAsString() {
        AlphabetCharacter c = AlphabetCharacter.from('C');
        assertEquals("C", c.asString());
        assertEquals("AlphabetCharacter{value=C}", c.toString());
    }
}
