package com.overengineered.alphabet.infrastructure.i18n;

import jakarta.enterprise.context.ApplicationScoped;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

@ApplicationScoped
public class MessageProvider {

    private static final String BUNDLE_BASE_NAME = "Messages";

    public String get(String key, Locale locale, Object... args) {
        ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_BASE_NAME, locale);
        String pattern = bundle.getString(key);
        return MessageFormat.format(pattern, args);
    }
}