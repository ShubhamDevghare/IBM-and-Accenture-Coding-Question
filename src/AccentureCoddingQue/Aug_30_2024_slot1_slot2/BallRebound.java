package AccentureCoddingQue.Aug_30_2024_slot1_slot2;
/*
Rebound Height
---------------
Que:
Daniel has a ball.
He wants to find the ball's rebound height, which he dropped from height H with an initial velocity V.
After the Nth rebound the final velocity of the ball is Vn.
Your task is to help him find and return an integer value representing
the height to which the ball rebounds after N bounces.

Note:

-   H' = H * e^2n , where H' is the rebound height, H is the initial height,
                    e is the coefficient of restitution and n is the number of bounces.

-   e^n = V / Vn  , where V is the initial velocity and Vn is the final velocity

Input Specification:
---------------------
input1: An integer H, representing initial height
input2: An integer V, representing initial velocity
input3: An integer Vn. representing final velocity

Output Specification:
---------------------
Return an integer value representing the height to which the ball rebounds after N bounces.

 */

public class BallRebound {

    public static int reboundHeight(int H, int V, int Vn) {
        // Calculate the coefficient of restitution e
        double e = (double) V / Vn;

        // Calculate the rebound height after N bounces
        double reboundHeight = H * Math.pow(e, 2);

        // Return the height as an integer
        return (int) reboundHeight;
    }

    public static void main(String[] args) {
        int H = 100; // Example initial height
        int V = 30;  // Example initial velocity
        int Vn = 15; // Example final velocity after N bounces

        int result = reboundHeight(H, V, Vn);
        System.out.println("The rebound height after N bounces is: " + result);
    }
}

