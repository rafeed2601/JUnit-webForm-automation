package Utils;

import java.util.Random;

public class RandomEmailGenerator {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String[] DOMAINS = {"example.com", "test.com", "demo.com", "sample.org"};
    private static final int USERNAME_LENGTH = 8;

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
    }
}
