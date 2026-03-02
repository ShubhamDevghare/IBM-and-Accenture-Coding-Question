package AccentureCoddingQue.Aug_14_2024;
/*
Que :
Alice has collection of songs represented as a string S where each character represents a song.
A playlist is the substring of the given string with exactly k number of songs.
She wants to create a playlist that contains maximum number of her favourite song which is 'a'.
Your task is to find and return an integer value representing the maximum number of favourite songs that
she can get in a single playlist


sliding window approach
-------------------------
 */
public class Playlist {
    public static int maxFavouriteSongs(String S, int k) {
        int n = S.length();
        int maxCount = 0;
        int currentCount = 0;

        // Count 'a's in the first window of size k
        for (int i = 0; i < k; i++) {
            if (S.charAt(i) == 'a') {
                currentCount++;
            }
        }

        // Initialize the maxCount with the count of 'a's in the first window
        maxCount = currentCount;

        // Slide the window through the string
        for (int i = k; i < n; i++) {
            // Remove the effect of the character leaving the window
            if (S.charAt(i - k) == 'a') {
                currentCount--;
            }
            // Add the effect of the new character entering the window
            if (S.charAt(i) == 'a') {
                currentCount++;
            }
            // Update the maximum count
            maxCount = Math.max(maxCount, currentCount);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        String S = "abacaba";
        int k = 3;
        System.out.println(maxFavouriteSongs(S, k));  // Output: 2
    }
}
