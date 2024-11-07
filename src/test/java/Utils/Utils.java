package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.security.SecureRandom;

public class Utils {
    public static void scroll(WebDriver driver, int height) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + height + ")");
    }

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String[] DOMAINS = {"example.com", "test.com", "demo.com", "sample.org"};
    private static final int USERNAME_LENGTH = 8;
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
    private static final int PASSWORD_LENGTH = 8;

    public static String generateRandomEmail() {
        Random random = new Random();

        // Generate random username
        StringBuilder username = new StringBuilder(USERNAME_LENGTH);
        for (int i = 0; i < USERNAME_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            username.append(CHARACTERS.charAt(index));
        }

        // Pick a random domain
        String domain = DOMAINS[random.nextInt(DOMAINS.length)];

        return username + "@" + domain;
    }

    public static void main(String[] args) {
        String randomEmail = generateRandomEmail();
        System.out.println("Random Email: " + randomEmail);
        System.out.println(generatePassword());
    }








        public static String generatePassword() {
            SecureRandom random = new SecureRandom();
            StringBuilder password = new StringBuilder();

            // Ensure at least one character from each category
            password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
            password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
            password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
            password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

            // Fill remaining characters with random characters from all categories
            for (int i = 4; i < PASSWORD_LENGTH; i++) {
                password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
            }

            // Shuffle the characters to make the password less predictable
            return shuffleString(password.toString());
        }

        private static String shuffleString(String input) {
            List<char[]> characters = Arrays.asList(input.toCharArray());
            Collections.shuffle(characters);
            StringBuilder result = new StringBuilder();
            for (char[] c : characters) {
                result.append(c);
            }
            return result.toString();
        }
    }



