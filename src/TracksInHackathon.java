import java.util.Scanner;
/*
Tracks in Hackathon
--------------------
There is a hackathon organized by HackerRank which has 2 separate tracks, healthcare and e-commerce.
For track 1, the required team size is teamSize_1, while for track 2, the required team size is teamSize_2.
The total number of participants is p.

Find the minimum number of teams into which the participants can be divided such that:

Each participant belongs to exactly one team (either of track 1 or track 2), and
Each team has a size equal to either teamSize_1 or teamSize_2.

If no such division is possible, return -1.

Example

Consider:
    teamSize_1 = 3
    teamSize_2 = 4

Optimally, there is:
  1 team of size 3
  1 team of size 4
Minimum number of teams = 2
p = 7

Function Description
----------------------
Complete the function:

int countTeams(int teamSize_1, int teamSize_2, int p)

Returns:
-------
int: the minimum number of teams into which the participants can be divided.

Constraints
-----------
1 ≤ teamSize_1 ≤ 10^5
1 ≤ teamSize_2 ≤ 10^5
1 ≤ p ≤ 10^5
 */
/* SLF ::
There is a hackathon organized by HackerRank which has 2 separate tracks, healthcare and e-commerce.
For track 1, the required team size is teamSize_1, while for track 2, the required team size is teamSize_2.
The total number of participants is p.
Find the minimum number of teams into which the participants can be divided such that:
Each participant belongs to exactly one team (either of track 1 or track 2), and
Each team has a size equal to either teamSize_1 or teamSize_2.
If no such division is possible, return -1.

🧠 Example
Input:
teamSize_1 = 3
teamSize_2 = 4
p = 6

Possible combinations:
2 teams of 3 → 6 ✔
1 team of 4 → 4 ✖
1 team of 3 + 1 team of 4 → 7 ✖

Answer: 2
 */
public class TracksInHackathon {

    public static int countTeams(int teamSize1, int teamSize2, int p) {

        int a = teamSize1;
        int b = teamSize2;

        // Ensure b is the larger team size
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        // Try maximum possible larger teams first
        for (int y = p / b; y >= 0; y--) {
            int remaining = p - (y * b);

            if (remaining % a == 0) {
                int x = remaining / a;
                return x + y;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int teamSize1 = scanner.nextInt();
        int teamSize2 = scanner.nextInt();
        int p = scanner.nextInt();

        int result = countTeams(teamSize1, teamSize2, p);
        System.out.println(result);

        scanner.close();
    }
}