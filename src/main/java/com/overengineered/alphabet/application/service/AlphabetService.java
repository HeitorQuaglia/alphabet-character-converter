package com.overengineered.alphabet.application.service;

import com.overengineered.alphabet.domain.AlphabetCharacter;
import com.overengineered.alphabet.domain.AlphabetPosition;

public interface AlphabetService {
    AlphabetCharacter getCharacterByPosition(AlphabetPosition position);
}
