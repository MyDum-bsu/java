package lab1;

import java.util.StringTokenizer;

public class Task7 {
    public static String deleteSinglesAndSpaces(String string) throws EmptyStringException {
        if (string.trim().isEmpty()) {
            throw new EmptyStringException("empty string");
        }
        StringTokenizer str = new StringTokenizer(string, " ", false);
        StringBuilder edited = new StringBuilder();

        while (str.hasMoreTokens()) {
            StringBuilder token = new StringBuilder(str.nextToken());
            boolean isAlpha = token.chars().allMatch(Character::isAlphabetic);
            if (token.length() != 1 || !isAlpha) {
                edited.append(token).append(" ");
            }
        }
        return edited.toString().trim();
    }

    public static void run(String str) {
            try {
                System.err.println(deleteSinglesAndSpaces(str));
            } catch (EmptyStringException e) {
                e.printStackTrace();
            }
    }
}