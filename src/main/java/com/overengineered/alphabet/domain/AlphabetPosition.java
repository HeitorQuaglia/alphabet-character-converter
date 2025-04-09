package com.overengineered.alphabet.domain;

import java.util.Objects;

public final class AlphabetPosition {

    private final int value;

    private AlphabetPosition(int value) {
        this.value = value;
    }

    public static AlphabetPosition from(int value) {
        validate(value);
        return new AlphabetPosition(value);
    }

    private static void validate(int value) {
        if (value < 1 || value > 26) {
            throw new IllegalArgumentException("Alphabet position must be between 1 and 26.");
        }
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AlphabetPosition)) return false;
        AlphabetPosition other = (AlphabetPosition) obj;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "AlphabetPosition{" +
                "value=" + value +
                '}';
    }
}
