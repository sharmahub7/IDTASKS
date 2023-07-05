import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;

        System.out.println("Welcome to Guess the Number game!");
        System.out.println("Choose a number between 1 and 100. You have 5 attempts.");

        while (attempts < 5) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
            if (guess < secretNumber) {
                System.out.println("Higher! Attempts remaining: " + (5 - attempts));
            } else if (guess > secretNumber) {
                System.out.println("Lower! Attempts remaining: " + (5 - attempts));
            } else {
                System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts!");
                scanner.close();
                return;
            }
        }
        System.out.println("Sorry, you didn't guess the number. The secret number was: " + secretNumber);
        scanner.close();
    }
}
