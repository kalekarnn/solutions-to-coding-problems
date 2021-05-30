import java.util.Arrays;

public class SubsetSum {

    public static void main(String[] args) {

        SubsetSum subsetSum = new SubsetSum();

        int[] input = {6, 4, 2, 12, -2};
        int sum = 10;

        System.out.println(subsetSum.isSubsetExist(input, sum));
        System.out.println(subsetSum.subsetSumCount(input, sum));
        System.out.println(subsetSum.equalSumPartition(input));

    }

    public boolean isSubsetExist(int[] input, int sum) {

        if (input.length == 0 && sum != 0) {
            return false;
        } else if (sum == 0) {
            return true;
        } else {
            return isSubsetExist(Arrays.copyOfRange(input, 0, input.length - 1), sum - input[input.length - 1]) ||
                    isSubsetExist(Arrays.copyOfRange(input, 0, input.length - 1), sum);
        }
    }

    public int subsetSumCount(int[] input, int sum) {

        if (input.length == 0 && sum != 0) {
            return 0;
        } else if (sum == 0) {
            return 1;
        } else {
            return subsetSumCount(Arrays.copyOfRange(input, 0, input.length - 1), sum - input[input.length - 1])
                    + subsetSumCount(Arrays.copyOfRange(input, 0, input.length - 1), sum);
        }
    }

    public boolean equalSumPartition(int[] input) {

        int total = 0;
        for (int i = 0; i < input.length; i++) {
            total += input[i];
        }

        if (total % 2 != 0) {
            return false;
        } else {
            return isSubsetExist(input, total / 2);
        }
    }

}
