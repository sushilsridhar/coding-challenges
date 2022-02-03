package recursion;

/*
    On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01,
    and each occurrence of 1 with 10.

    Given row A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.) (1 indexed).

     A = 2
     B = 2

    Row 1: 0
    Row 2: 01

    output: 1
 */
public class KthSymbol {

    public static void main(String[] args) {

        System.out.println(solve(2,2));

    }

    public static int solve(int A, int B) {
        StringBuilder builder = new StringBuilder("0");
        int iterationCount = 1;
        StringBuilder newBuilder = symbol(builder, iterationCount, A);
        return Character.getNumericValue(newBuilder.charAt(B-1));
    }

    private static StringBuilder symbol(StringBuilder builder , int iterationCount, int totalIteration) {

        if(iterationCount == totalIteration) {
            return builder;
        }

        StringBuilder newBuilder = new StringBuilder();

        for(int i=0; i<builder.length(); i++) {
            if(builder.charAt(i) == '0') {
                newBuilder.append("01");
            } else if(builder.charAt(i) == '1') {
                newBuilder.append("10");
            }
        }

        return symbol(newBuilder, iterationCount+1, totalIteration);
    }
}
