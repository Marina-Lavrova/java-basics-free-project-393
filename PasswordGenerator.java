public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    public static String generatePassword(int length) {
        StringBuilder result = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int index = (int) (Math.random() * LOWERCASE.length());
                result.append(index);
            }
            return result.toString();
    }
}