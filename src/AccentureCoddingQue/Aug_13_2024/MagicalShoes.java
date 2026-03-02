package AccentureCoddingQue.Aug_13_2024;
/*
//this type of Ques not Asked
// Very Easy...........
Que :
Alice has a pair of magical shoes that allows her to climb 3 stairs at once.
In the city there are N houses whose roof Alice wants to reach.
The number of roofs of each house is given in an array A.
Alice can reach the roof of only those houses where the number is a multiple of 3.
Your task is to find and return integer value representing the count of the number of houses
whose roof Alice can climb.

 */
public class MagicalShoes {
    public static int countClimbableHouses(int[] roofs) {
        int count = 0;

        for (int roof : roofs) {
            if (roof % 3 == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] houseRoofs = {3, 5, 9, 12, 15, 7, 8};
        int result = countClimbableHouses(houseRoofs);
        System.out.println("Total number of houses Alice can climb: " + result);
    }
}

