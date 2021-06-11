/***********************************************************************************************
 *
 * Count the number of possible triangles
 *
 * Given an unsorted array arr[] of n positive integers. Find the number of triangles
 * that can be formed with three different array elements as lengths of three sides
 * of triangles.
 *
 * Example 1:
 *
 * Input:
 * n = 3
 * arr[] = {3, 5, 4}
 * Output:
 * 1
 * Explanation:
 * A triangle is possible
 * with all the elements 5, 3 and 4.
 *
 * Your Task:
 * This is a function problem. You only need to complete the function findNumberOfTriangles()
 * that takes arr[] and n as input parameters and returns the count of total possible triangles.
 *
 *************************************************************************************************/

import java.util.Arrays;

public class NumberOfPossibleTriangles {

    public static void main(String[] args) {
        NumberOfPossibleTriangles possibleTriangles = new NumberOfPossibleTriangles();

        int n = 6;
        int arr[] = {26, 9, 27, 22, 16, 27};
        System.out.println(possibleTriangles.findNumberOfTrianglesOptimized(arr, n));
    }

    int findNumberOfTriangles(int arr[], int n) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (arr[i] + arr[j] > arr[k] && arr[i] + arr[k] > arr[j] && arr[j] + arr[k] > arr[i]) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    int findNumberOfTrianglesOptimized(int arr[], int n) {
        int result = 0;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {

            int k = i + 2;
            for (int j = i + 1; j < n; j++) {

                while (k < n && arr[i] + arr[j] > arr[k]) {
                    k++;
                }
                if (k > j){
                    result += k - j - 1;
                }
            }
        }
        return result;
    }
}


