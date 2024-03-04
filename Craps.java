import java.util.Scanner;
import java.util.Random;

public class Craps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        boolean playAgain = true; //insert boolean for play again option

        while (playAgain) {
            int die1 = rnd.nextInt(6) + 1; // defining variables. dice roll 1
            int die2 = rnd.nextInt(6) + 1; // dice roll 2
            final int crapsRoll = die1 + die2; // sum of dice

            System.out.println("Rolling the dice...");
            System.out.println("Die 1: " + die1); //telling user first dice roll
            System.out.println("Die 2: " + die2); //telling user second dice roll
            System.out.println("Sum: " + crapsRoll); //telling user sum of dice roll

            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) { // see if user wins the round
                System.out.println("Craps! You lose."); // the sum cannot be 2,3,12 so they lose
            }
            else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("Natural! You win."); // sum of a 7 or 11 is win
            }
            else {
                System.out.println("Point is " + crapsRoll);
                System.out.println("Trying for point..."); //neither win or lose so the dice rolls again

                boolean continueRolling = true; // roll again

                while (continueRolling) {
                    int nextDie1 = rnd.nextInt(6) + 1;
                    int nextDie2 = rnd.nextInt(6) + 1;
                    int nextRoll = nextDie1 + nextDie2;

                    System.out.println("Rolling the dice..."); // repeat everything from above
                    System.out.println("Die 1: " + nextDie1);
                    System.out.println("Die 2: " + nextDie2);
                    System.out.println("Sum: " + nextRoll);


                    if (nextRoll == crapsRoll) {
                        System.out.println("Made point! You win.");
                        continueRolling = false;
                    }
                    else if (nextRoll == 7) {
                        System.out.println("Got a 7! You lose.");
                        continueRolling = false;
                    }
                    else {
                        System.out.println("Trying for point..."); // this continues until theres a win or lose
                    }
                }

            }
            System.out.println("Do you want to play again? (yes/no): "); // prompt user
            String playAgainInput = in.next().toLowerCase(); //put user input to lower case
            playAgain = playAgainInput.equals("yes"); //prompt user and if yes, game will play again

        }
        System.out.println("Thanks for playing!"); //out print message for end of game
    }
}
