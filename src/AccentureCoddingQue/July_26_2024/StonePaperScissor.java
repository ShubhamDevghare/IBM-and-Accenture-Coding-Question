package AccentureCoddingQue.July_26_2024;
/*
Rock, Paper and Scissors:
Two players A and B are playing the game of Rock, Paper and scissors. Player A
chooses a move represented by String M and the move can be one of the following: Rock,
paper or scissors
where 1-Rock beats scissors
2- Scissor beats paper
3- Paper beats rock
Your task is to find and return a string value representing the
winning move for B.

 */
import java.util.Scanner;

public class StonePaperScissor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();  // Read the user's input

        if (A.equals("rock")) {
            System.out.println("paper");
        } else if (A.equals("paper")) {
            System.out.println("scissor");
        } else {
            System.out.println("rock");
        }

        sc.close();
    }
}
