/*
A Mars rover is directed to move within a square matrix.
It accepts a sequence of commands to move in any of the four directions from each cell: [UP, DOWN, LEFT or RIGHT).
The rover starts from cell 0. and may not move diagonally or outside of the boundary.
Each cell in the matrix has a position equal to:

(row * size) = column

where row and column are zero-indexed, size = row length of the matrix.
Return the final position of the rover after all moves.

slf :
1. Square matrix of size n × n
2. Start at position (0,0)

Example:
n = 4
commands = [RIGHT, UP, DOWN, LEFT, DOWN, DOWN]

The rover moves within the following 4 × 4 matrix:

0   1   2   3                RIGHT: Rover moves to position 1
4   5   6   7                UP   : Position unchanged as the move would take the rover out of the boundary
8   9  10  11                DOWN : Rover moves to Position 5
12 13  14  15                LEFT : Rover moves to Position 4
                             DOWN : Rover moves to Position 8
                             DOWN : Rover moves to Position 12

After executing all commands, the rover ends at position 12.

Return :  12
 */
public class MarsRover {

    public static int finalPosition(int n, String[] commands) {
        int row = 0;
        int col = 0;

        for (String command : commands) {
            switch (command) {
                case "UP":
                    if (row > 0) row--;
                    break;

                case "DOWN":
                    if (row < n - 1) row++;
                    break;

                case "LEFT":
                    if (col > 0) col--;
                    break;

                case "RIGHT":
                    if (col < n - 1) col++;
                    break;
            }
        }

        return row * n + col;
    }

    public static void main(String[] args) {
        int n = 4;
        String[] commands = {"RIGHT", "UP", "DOWN", "LEFT", "DOWN", "DOWN"};
        System.out.println(finalPosition(n, commands));  // Output: 12
    }
}