package com.overengineered.alphabet.domain;

import com.overengineered.alphabet.exception.InvalidLetterException;
import com.overengineered.alphabet.exception.LetterOutOfRangeException;

import java.util.Objects;

public final class AlphabetCharacter {

    private final char value;

    private AlphabetCharacter(char value) {
        this.value = value;
    }

    public static AlphabetCharacter from(char value) {
        validate(value);
        return new AlphabetCharacter(Character.toUpperCase(value));
    }

    private static void validate(char value) {
        if (!Character.isLetter(value)) {
            throw new InvalidLetterException();
        }
        char upper = Character.toUpperCase(value);
        if (upper < 'A' || upper > 'Z') {
            throw new LetterOutOfRangeException();
        }
    }

    public char value() {
        return value;
    }

    public String asString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AlphabetCharacter)) return false;
        AlphabetCharacter other = (AlphabetCharacter) obj;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "AlphabetCharacter{" +
                "value=" + value +
                '}';
    }
}
