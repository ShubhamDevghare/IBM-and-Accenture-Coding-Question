/*
A password string, pwd, consists of binary characters (0s and 1s).
A cyber security expert is trying to determine the minimum number of changes required to make the password secure.
To do so, it must be divided into substrings of non-overlapping, even length substrings. Each substring can only contain
1s or 0s, not a mix. This helps to ensure that the password is strong and less vulnerable to hacking attacks.

Find the minimum number of characters that must be flipped in the password string,
i.e., changed from 0 to 1 or 1 to 0 to allow the string to be divided as described.
 */
import java.util.Scanner;

    public class SecurePassword {

        public static int minFlips(String pwd) {
            int n = pwd.length();

            // If length is odd, cannot divide into even substrings
            if (n % 2 != 0) {
                return -1;
            }

            int flips = 0;

            // Check every pair
            for (int i = 0; i < n; i += 2) {
                if (pwd.charAt(i) != pwd.charAt(i + 1)) {
                    flips++;
                }
            }
            return flips;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            // Input password string
            String pwd = sc.nextLine();
            int result = minFlips(pwd);
            System.out.println(result);
            sc.close();
        }
    }