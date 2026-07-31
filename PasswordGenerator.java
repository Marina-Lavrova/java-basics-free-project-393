public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";

    public static String generatePassword(int length, boolean useUppercase, boolean useDigits) {
        StringBuilder result = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int index = (int) (Math.random() * LOWERCASE.length());
                char chRandomLow = (char) (Math.random() * LOWERCASE.length());
                char chRandomUpper = (char) (Math.random() * UPPERCASE.length());
                char chRandomDigit = (char) (Math.random() * DIGITS.length());
                result.append(LOWERCASE.charAt(index));
            }
            return result.toString();
    }
}