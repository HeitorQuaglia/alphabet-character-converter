package com.overengineered.alphabet.application.service;

import com.overengineered.alphabet.domain.AlphabetCharacter;
import com.overengineered.alphabet.domain.AlphabetPosition;
import com.overengineered.alphabet.domain.LetterEnum;
import com.overengineered.alphabet.exception.AlphabetNotFoundException;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResolveAlphabetCharacter implements AlphabetService {

    @Override
    public AlphabetCharacter getCharacterByPosition(AlphabetPosition position) {
        return LetterEnum.fromPosition(position.value())
                .map(LetterEnum::toAlphabetCharacter)
                .orElseThrow(() -> new AlphabetNotFoundException(position));
    }
}
