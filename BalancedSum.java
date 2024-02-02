import java.util.List;


//balancedSum : write a function some of all the elements to the left and
// right of the index are equal , return that index.
// if no such index exists return -1
public class BalancedSum {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 5, 3, 4, 2);
        System.out.println(balancedSum(list));

    }

        static int balancedSum(List<Integer> arr) {
        int size = arr.size();
        int rSum = arr.stream().skip(1).mapToInt(Integer::intValue).sum();
        int lSum = 0;

        for (int i = 0, j = 1; j < size; i++, j++) {
            rSum -= arr.get(j);
            lSum += arr.get(i);

            if (lSum == rSum)
                return i + 1;
        }


        return -1;
    }
}
