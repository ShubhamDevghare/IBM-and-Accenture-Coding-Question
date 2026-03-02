package AccentureCoddingQue.Aug_20_2024;
/*
Que:
You are provided with a string which has a sequence of 1s and Os.
This sequence is the encoded version of a english word.
You are supposed to write a program to decode the provided string and find the original word.
Each uppercase Alphabet is representing by a sequence of 1s.

slef:
A -> 1
b -> 11
c -> 111
...  ...
...  ...
z -> 111...

0 - represent space

 */

import java.util.Scanner;

public class StringDecoder {
    public static String solve(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {  // when you hit 0
                if (count > 0) {
                    ans.append((char) ('A' + count - 1));
                    count = 0;
                }
            }
        }

        // Check if there's a trailing count [ bcz at the end of String there is no chance of hitting 0 ]
        if (count > 0) {
            ans.append((char) ('A' + count - 1));
        }

        return ans.toString();  //
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.println(solve(s));
        scanner.close();
    }
}
