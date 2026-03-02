package AccentureCoddingQue.Aug_16_2024_slot1;

public class EvenOddLabel {

    public static String evenOddLabel(int[] A) {
        StringBuilder result = new StringBuilder();

        for (int num : A) {
            if (num % 2 == 0) {
                result.append("Even");
            } else {
                result.append("Odd");
            }
        }
        return result.toString();     // StringBuilder to String
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(evenOddLabel(A));
    }
}
