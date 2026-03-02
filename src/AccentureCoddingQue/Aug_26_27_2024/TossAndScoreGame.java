package AccentureCoddingQue.Aug_26_27_2024;
/*
Que:
Toss and Score
-----------------
You are playing a game of Toss and Score in the Hillwood City Mall with your friends.
The game consists of the following rules:
* Toss an unbiased coin multiple times.
* For each heads you get 2 points and for each tails you lose 1 point.
* The game ends as soon as you get 3 heads in a row, or you toss the coin throughtout the length of string S.

You have been given a string S consisting of letters H (for heads) and T (for tails) sequence of result.
Your task is to find and results you get on the toss of coin N integer value representing the final score
you get once the game ends.

--------------------------------------------------------------------------------------------------------------------
Steps to Solve: [Self]
Initialize the score: Start with a score of 0.
Process each character of the string:
If it's 'H', add 2 points to the score.
If it's 'T', subtract 1 point from the score.
Check for 3 heads in a row: Track consecutive heads, and if you encounter 3 heads in a row, stop the game early.
Return the final score: The final score will be the accumulated score when the game ends.

 */

import java.util.Scanner;

public class TossAndScoreGame {

    public static int calculateFinalScore(String Str) {
        int score = 0;
        int consecutiveHeads = 0;  // Track consecutive heads


        for (int i = 0; i < Str.length(); i++) {
            char toss = Str.charAt(i);

            if (toss == 'H') {
                score += 2;
                consecutiveHeads++;  // Increment consecutive heads counter

                // Check if there are 3 heads in a row
                if (consecutiveHeads == 3) {
                    break;  // Game ends if 3 heads in a row are encountered
                }
            } else if (toss == 'T') {
                score -= 1;
                consecutiveHeads = 0;  // Reset consecutive heads counter
            }
        }

        return score;  // Return the final score after the game ends
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string representing the toss sequence
        System.out.print("Enter the toss sequence (H for heads, T for tails): ");
        String tossSequence = scanner.nextLine();

        // Calculate and print the final score
        int finalScore = calculateFinalScore(tossSequence);
        System.out.println("Final score: " + finalScore);

        scanner.close();
    }
}
