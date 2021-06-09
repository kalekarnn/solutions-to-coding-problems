/*************************************************************************************
 *
 * Minimum Platforms
 *
 * Given arrival and departure times of all trains that reach a railway station.
 * Find the minimum number of platforms required for the railway station so
 * that no train is kept waiting.
 *
 * Consider that all the trains arrive on the same day and leave on the same day.
 * Arrival and departure time can never be the same for a train but we can have
 * arrival time of one train equal to departure time of the other. At any given
 * instance of time, same platform can not be used for both departure of a train
 * and arrival of another train. In such cases, we need different platforms,
 *
 *
 * Example 1:
 *
 * Input: n = 6
 * arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
 * dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
 * Output: 3
 * Explanation:
 * Minimum 3 platforms are required to
 * safely arrive and depart all trains.
 *
 * Example 2:
 *
 * Input: n = 3
 * arr[] = {0900, 1100, 1235}
 * dep[] = {1000, 1200, 1240}
 * Output: 1
 * Explanation: Only 1 platform is required to
 * safely manage the arrival and departure
 * of all trains.
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete
 * the function findPlatform() which takes the array arr[] (denoting the arrival times),
 * array dep[] (denoting the departure times) and the size of the array as inputs and
 * returns the minimum number of platforms required at the railway station such that
 * no train waits.
 *
 *
 **************************************************************************************/


import java.util.Arrays;

public class MinimumPlatforms {

    public static void main(String[] args) {

        MinimumPlatforms minimumPlatforms = new MinimumPlatforms();

        int n = 3;
        int[] arr = {900, 1100, 1235};
        int[] dep = {1000, 1200, 1240};

        System.out.println(minimumPlatforms.findPlatform(arr, dep, n));
    }

    int findPlatform(int arr[], int dep[], int n) {

        int counter = 0, noOfPlatforms = 0, i = 0, j = 0;

        Arrays.sort(arr);
        Arrays.sort(dep);

        while ((i < n) && (j < n)) {

            if (arr[i] <= dep[j]) {
                counter++;
                i++;
            } else if (arr[i] > dep[j]) {
                counter--;
                j++;
            }

            noOfPlatforms = Math.max(counter, noOfPlatforms);
        }

        return noOfPlatforms;
    }
}
