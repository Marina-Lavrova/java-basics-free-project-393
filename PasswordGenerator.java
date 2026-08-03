public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*";

    private static long nextRandom(long number) {
        return (16807L * number) % 2147483647L;
    }

    public static String generatePassword(
        int length,
        long seed,
        boolean useUppercase,
        boolean useDigits,
        boolean useSpecial
    ) {
        StringBuilder result = new StringBuilder();

        String alphabet = LOWERCASE;

        if (useUppercase) {
            alphabet += UPPERCASE;
        }

        if (useDigits) {
            alphabet += DIGITS;
        }

        if (useSpecial) {
            alphabet += SPECIAL;
        }

        /*long current = seed;

        for (int i = 0; i < length; i++) {
            int index = (int) (current % alphabet.length());
            current = nextRandom(current);

            result.append(alphabet.charAt(index));
        }*/

        long current = nextRandom(seed);  // сдвиг до первого символа
        for (int i = 0; i < length; i++) {
            int index = (int) (current % alphabet.length());
            result.append(alphabet.charAt(index));
            current = nextRandom(current);
        }
        return result.toString();
    }

    public static String checkPassword(String password) {
        int score = 0;

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        if (password.length() >= 8) {
            score++;
        }

        for (char c : password.toCharArray()) {
            if (!hasLower && LOWERCASE.indexOf(c) >= 0) {
                hasLower = true;
                score++;
            } else if (!hasUpper && UPPERCASE.indexOf(c) >= 0) {
                hasUpper = true;
                score++;
            } else if (!hasDigit && DIGITS.indexOf(c) >= 0) {
                hasDigit = true;
                score++;
            } else if (!hasSpecial && SPECIAL.indexOf(c) >= 0) {
                hasSpecial = true;
                score++;
            }

            if (hasLower && hasUpper && hasDigit && hasSpecial) {
                break;
            }
        }

        String result;
        switch (score) {
            case 5: result = "Очень надёжный"; break;
            case 4: result = "Надёжный"; break;
            case 3: result = "Средний"; break;
            default: result = "Слабый"; break;
        }
        return result + " (пароль оценка " + score + " из 5)";
    }
}
