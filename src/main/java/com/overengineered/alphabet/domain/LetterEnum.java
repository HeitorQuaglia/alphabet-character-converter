package com.overengineered.alphabet.domain;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public enum LetterEnum {

    A(1), B(2), C(3), D(4), E(5), F(6),
    G(7), H(8), I(9), J(10), K(11), L(12),
    M(13), N(14), O(15), P(16), Q(17), R(18),
    S(19), T(20), U(21), V(22), W(23), X(24),
    Y(25), Z(26);

    private final int position;

    private static final Map<Integer, LetterEnum> POSITION_MAP = new HashMap<>();

    static {
        for (LetterEnum letter : values()) {
            POSITION_MAP.put(letter.position, letter);
        }
    }

    LetterEnum(int position) {
        this.position = position;
    }

    public int position() {
        return position;
    }

    public AlphabetCharacter toAlphabetCharacter() {
        return AlphabetCharacter.from(this.name().charAt(0));
    }

    public static Optional<LetterEnum> fromPosition(int position) {
        return Optional.ofNullable(POSITION_MAP.get(position));
    }
}
