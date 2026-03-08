
import java.util .*;
public class GCD_LCM {


    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        // Input two numbers
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        // Store original values
        int on1 = n1;
        int on2 = n2;

        // Calculate GCD using Euclidean Algorithm
        while (n1 % n2 != 0) {
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }

        int gcd = n2;

        // Calculate LCM
        int lcm = (on1 * on2) / gcd;

        // Print results
        System.out.println(gcd);
        System.out.println(lcm);
    }
}