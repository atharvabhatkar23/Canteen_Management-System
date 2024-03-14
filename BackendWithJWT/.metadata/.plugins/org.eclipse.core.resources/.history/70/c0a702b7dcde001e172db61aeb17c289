package com.app.random;

import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String SPECIAL_CHAR = "!@#$%&*";

    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + SPECIAL_CHAR;

    private static SecureRandom random = new SecureRandom();

    public static String generateRandomPassword(int length) {
        if (length < 4) {
            throw new IllegalArgumentException("Password length must be at least 4 characters.");
        }

        StringBuilder password = new StringBuilder(length);
        String allowBase = PASSWORD_ALLOW_BASE;

        // At least one lowercase character
        password.append(CHAR_LOWER.charAt(random.nextInt(CHAR_LOWER.length())));

        // At least one uppercase character
        password.append(CHAR_UPPER.charAt(random.nextInt(CHAR_UPPER.length())));

        // At least one digit
        password.append(NUMBER.charAt(random.nextInt(NUMBER.length())));

        // At least one special character
        password.append(SPECIAL_CHAR.charAt(random.nextInt(SPECIAL_CHAR.length())));

        // Rest of the password, random characters from PASSWORD_ALLOW_BASE
        for (int i = 0; i < length - 4; i++) {
            password.append(allowBase.charAt(random.nextInt(allowBase.length())));
        }

        return password.toString();
    }
}