package AccentureCoddingQue.Aug_16_2024_slot2;
/*
Que:
You are developing a feature for an environmental awareness app that helps users to know
 how much area their tree's shadow covers. You have the distance D from a tree's trunk to the edge of the shadow.
 Your task is to calculate and return an integer value representing the shadow area of the canopy.
Note:- Round off the result to nearest integer.

Input Specification:

input1: An integer value D, representing the distance from the tree trunks to the edge of shadow.

Output Specification:
Return an integer value representing the shadow area of the canopy.

----------------------------------------------------------------------------------------------------------------
To calculate the shadow area of the canopy, we can model the tree's shadow as a circular region,
 where the radius of the circle is the given distance D from the tree's trunk to the edge of the shadow.

The formula for the area of a circle is:
Area = 𝜋 ×𝑟2
Here, r is the radius, which is equal to the given distance D.
After calculating the area, we will round off the result to the nearest integer.

 */


public class TreeShadowCalculator {

    public static int calculateShadowArea(int D) {
        // Calculate the area of the circle (π * r^2)
        double area = Math.PI * Math.pow(D, 2);

        // Round off the area to the nearest integer
        return (int) Math.round(area);
    }

    public static void main(String[] args) {
        // Example input
        int D = 5;

        // Calculate and print the shadow area
        int shadowArea = calculateShadowArea(D);
        System.out.println("The shadow area of the canopy is: " + shadowArea);
    }
}
