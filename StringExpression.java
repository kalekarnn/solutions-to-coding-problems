public class StringExpression {

    public static void main(String[] args) {
        String input = "3[a]2[bc]";
        //aaabcbc
        System.out.println(simplify(input));
    }

    private static String simplify(String input) {

        String result = "";

        String[] tempSamples = input.split("]");
        for (String tempSample : tempSamples) {
            String[] sample = tempSample.split("\\[");

            int count = Integer.parseInt(sample[0]);

            int i = 0;
            while (i < count) {
                result += sample[1];
                i++;
            }
        }
        return result;
    }
}
