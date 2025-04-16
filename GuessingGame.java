import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("=== Welcome to the Number Guessing Game! ===");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("😢 You've run out of attempts. The number was: " + numberToGuess);
            }

            System.out.println("Your total score: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // Clear newline
            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
                System.out.println("Thanks for playing! Final score: " + totalScore);
            }
        }

        scanner.close();
    }
}
