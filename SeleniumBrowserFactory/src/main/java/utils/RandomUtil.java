package utils;

import java.security.SecureRandom;

public class RandomUtil {
    private static final SecureRandom random = new SecureRandom();
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String generateAlphabetic(int length) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i <  length; ++i) {
            result.append(alphabet[random.nextInt(alphabet.length)]);
        }
        return result.toString();
    }
}
