public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*";

    private static long nextRandom(long number) {
        return (16807L * number) % 2147483647L;
    }

    public static String generatePassword(int length, long seed, boolean useUppercase, boolean useDigits, boolean useSpecial) {
        StringBuilder result = new StringBuilder();
        
        //if (length <=0){return "";}

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

        long current = seed;

        for (int i = 0; i < length; i++) {
                
                //int index = (int) (Math.random() * alphabet.length());                


                int index = (int)(current % alphabet.length());
                current = nextRandom(current);

                result.append(alphabet.charAt(index));
            }
            return result.toString();
    }
}