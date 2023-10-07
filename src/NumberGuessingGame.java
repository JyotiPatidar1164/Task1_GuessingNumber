import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        
        boolean playAgain = true;
        
        while (playAgain) {
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            
            System.out.println("-----------------------Welcome to the Number Guessing Game!--------------------------");
            System.out.println("Enter Number Between " + minRange + " And " + maxRange + ".");
            
            while (attempts < maxAttempts) {
                System.out.println("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please enter a number within the specified range.");
                    continue;
                }
                
                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number..");
                }
                
                if (attempts == maxAttempts) {
                    System.out.println("Congratulations! You guessed the number in"+ secretNumber + "attempts.");
                }
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thank you for playing! Goodbye.");
        scanner.close();
    }
}
