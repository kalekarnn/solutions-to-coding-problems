/***************************************************************************************
 *
 * The stock span problem
 *
 * The stock span problem is a financial problem where we have a series of n daily
 * price quotes for a stock and we need to calculate the span of stock’s price for
 * all n days. The span Si of the stock’s price on a given day i is defined as the
 * maximum number of consecutive days just before the given day, for which the price
 * of the stock on the current day is less than or equal to its price on the given day.
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
 * then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
 *
 *
 * Input:
 * N = 7, price[] = [100 80 60 70 60 75 85]
 *
 * Output:
 * 1 1 1 2 1 4 6
 *
 * Explanation:
 * Traversing the given input span for 100
 * will be 1, 80 is smaller than 100 so the
 * span is 1, 60 is smaller than 80 so the
 * span is 1, 70 is greater than 60 so the
 * span is 2 and so on. Hence the output will
 * be 1 1 1 2 1 4 6.
 *
 *****************************************************************************************/

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {
        int price[] = {68, 735, 101, 770, 525, 279, 559}; //1 2 1 4 1 1 3

        StockSpan stockSpan = new StockSpan();
        int[] res = stockSpan.calculateSpanOptimized(price, price.length);

        Arrays.stream(res).forEach(value -> System.out.print(value + " , "));

    }

    public int[] calculateSpan(int price[], int n) {
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (price[j] <= price[i]) {
                    span++;
                } else {
                    break;
                }
            }
            result[i] = span;
        }

        return result;
    }

    public int[] calculateSpanOptimized(int price[], int n) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        result[0] = 1;

        for (int i = 1; i < n; i++) {

            while (!stack.empty() && price[i] >= price[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.empty() ? i + 1 : i - stack.peek();

            stack.push(i);

        }
        return result;
    }


}
