/**************************************************************************************
 *
 * Given a square matrix[][] of size N x N.
 * The task is to rotate it by 90 degrees in an anti-clockwise direction
 * without using any extra space.
 *
 * Input:
 * N = 3
 * matrix[][] = [[1 2 3],
 *               [4 5 6],
 *               [7 8 9]]
 * Output:
 * 3 6 9
 * 2 5 8
 * 1 4 7
 *
 */

public class RotateBy90DegreeAntiClockwise {

    public static void main(String[] args) {
        RotateBy90DegreeAntiClockwise by90Degree = new RotateBy90DegreeAntiClockwise();

        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        by90Degree.rotate(input);
        by90Degree.display(input);
    }

    void rotate(int[][] matrix) {

        //transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //swap top-bottom
        int top = 0;
        int bottom = matrix.length - 1;

        while (top < bottom) {
            //swap
            int[] temp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;

            top++;
            bottom--;
        }
    }

    void display(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
