package com.beesion.ms.test.util;

import java.security.SecureRandom;

import com.beesion.ms.test.dto.PolicyDomainDto;

public class PasswordGenerator {

    private static final SecureRandom random = new SecureRandom();

    public static String generate(PolicyDomainDto policy) {
        PolicyValidator.validate(policy);
        StringBuilder password = new StringBuilder(policy.getMinLength());
        String allowedChars = buildAllowedChars(policy, password);
        fillRemainingChars(policy, password, allowedChars);
        shufflePassword(password);
        return password.toString();
    }

    private static void validatePolicy(PolicyDomainDto policy) {
        if (policy.getMinLength() < 4) {
            throw new IllegalArgumentException("La longitud de la contraseña debe ser al menos 4 caracteres.");
        }
    }

    private static String buildAllowedChars(PolicyDomainDto policy, StringBuilder password) {
        String allowedChars = "";
        if (policy.getRestrictMinLowerCaseLetters()) {
            allowedChars += appendRandomChars(password, "abcdefghijklmnopqrstuvwxyz", policy.getMinLowerCaseLetters());
        }
        if (policy.getRestrictMinUpperCaseLetters()) {
            allowedChars += appendRandomChars(password, "ABCDEFGHIJKLMNOPQRSTUVWXYZ", policy.getMinUpperCaseLetters());
        }
        if (policy.getRestrictMinDigits()) {
            allowedChars += appendRandomChars(password, "0123456789", policy.getMinDigits());
        }
        if (policy.getRestrictMinNonAlphanumericCharacters()) {
            allowedChars += appendRandomChars(password, "!#.", policy.getMinNonAlphanumericCharacters());
        }
        return allowedChars;
    }

    private static String appendRandomChars(StringBuilder password, String source, int count) {
        for (int i = 0; i < count; i++) {
            password.append(source.charAt(random.nextInt(source.length())));
        }
        return source;
    }

    private static void fillRemainingChars(PolicyDomainDto policy, StringBuilder password, String allowedChars) {
        while (password.length() < policy.getMinLength()) {
            password.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
        }
    }

    private static void shufflePassword(StringBuilder password) {
        for (int i = 0; i < password.length(); i++) {
            int randomIndex = random.nextInt(password.length());
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(randomIndex));
            password.setCharAt(randomIndex, temp);
        }
    }
}