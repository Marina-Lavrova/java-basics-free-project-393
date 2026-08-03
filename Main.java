public class Main {
    public static void main(String[] args) {
        /*System.out.println(PasswordGenerator.generatePassword(35,true,true,true));
        System.out.println(PasswordGenerator.generatePassword(20,true,true,true));*/
        
        //System.out.println(PasswordGenerator.generatePassword(-10, 1L, true, true, false));
        //System.out.println(PasswordGenerator.generatePassword(12, 123L, true, true, false));
        //System.out.println(PasswordGenerator.generatePassword(12, 123L, true, true, true));
        //System.out.println(PasswordGenerator.generatePassword(8, 1L, false, false, false));

        System.out.println(PasswordGenerator.checkPassword("abc"));
        System.out.println(PasswordGenerator.checkPassword("abcdefgh"));
        System.out.println(PasswordGenerator.checkPassword("abcdef1234"));
        System.out.println(PasswordGenerator.checkPassword("Abcdef1234"));
        System.out.println(PasswordGenerator.checkPassword("Abcdef123!"));
    }
}