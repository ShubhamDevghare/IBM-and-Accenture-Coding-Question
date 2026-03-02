package AccentureCoddingQue.Aug_26_27_2024;
/*
Que:
Given an array, String arr = {"gender", "blender", "blunder", "under"} Input string is " thunder".
From the array return the word that rhymes the most with the given word.
And if two words rhymes the most then return the word with less character count.
(example in blunder and under, the output will be "under").

============================================================================================================

score == maxScore && currentword.length() < bestMatch.length()
----------------------------------------------------------------
The goal is to find the word that rhymes the most with the input string.
However, if two or more words have the same rhyme score (meaning they rhyme equally well),
you want to select the shorter word.

- score == maxScore: This part checks if the current word has the same rhyme score as the best word found so far.
- word.length() < bestMatch.length(): If the rhyme score is tied, this part ensures that you pick the word
  with fewer characters (the shorter word).

 */

public class RhymeFinder {

    // Method to calculate rhyme score based on common suffix
    public static int rhymeScore(String word1, String word2) {
        int minLength = Math.min(word1.length(), word2.length());
        int score = 0;

        // Check for matching suffix characters
        for (int i = 1; i <= minLength; i++) {
            if (word1.charAt(word1.length() - i) == word2.charAt(word2.length() - i)) {
                score++;
            } else {
                break;
            }
        }
        return score;
    }

    // Method to find the best rhyming word
    public static String findBestRhyme(String[] words, String input) {
        input = input.trim(); // Remove leading/trailing whitespace
        String bestMatch = "";
        int maxScore = -1;

        for (String currentword : words) {
            int score = rhymeScore(currentword, input);

            // Check for a better rhyme or shorter word with the same score
            if (score > maxScore || (score == maxScore && currentword.length() < bestMatch.length())) {
                maxScore = score;
                bestMatch = currentword;
            }
        }
        return bestMatch;
    }

    public static void main(String[] args) {
        String[] arr = {"gender", "blender", "blunder", "under"};
        String input = " thunder";

        String result = findBestRhyme(arr, input);
        System.out.println("Best rhyming word: " + result);
    }
}
