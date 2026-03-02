/*
// Using String Builder :

public class ReverseStringExample {
    public static void main(String[] args) {
        String input = "Hello World";
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println(reversed);
    }
}
 */

public class ReverseString {
        public static void main(String[] args) {
            String input = "This is a simple test.";
            char[] chars = input.toCharArray();

            int left = 0;
            int right = chars.length - 1;

            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }

            System.out.println(new String(chars));
        }
    }
