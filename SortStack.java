/************************************************************************
 *
 * Given a stack, the task is to sort it such that the top of the
 * stack has the greatest element.
 *
 * Example 1:
 *
 * Input:
 * Stack: 3 2 1
 * Output: 3 2 1
 * Example 2:
 *
 * Input:
 * Stack: 11 2 32 3 41
 * Output: 41 32 11 3 2
 *
 ***************************************************************************/


import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        SortStack sortStack = new SortStack();

        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(10);
        integerStack.push(3);
        integerStack.push(7);

        System.out.println(integerStack);

        System.out.println(sortStack.sort(integerStack));
    }

    public Stack<Integer> sort(Stack<Integer> s) {

        int[] integers = new int[s.size()];

        int i = 0;
        while (!s.isEmpty()) {
            integers[i] = s.pop();
            i++;
        }

        java.util.Arrays.sort(integers);
        for (int j = 0; j < integers.length; j++) {
            s.push(integers[j]);
        }
        return s;
    }
}
