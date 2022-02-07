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

    approach:

    1 - 0                    , len - 1
    2 - 01                   , len - 2
    3 - 0110                 , len - 4
    4 - 0110 1001            , len - 8
    5 - 0110 1001 1001 0110  , len - 16

    n=5, B=10, answer = 0
    (5, 2) => 1
    (5, 10) => !(5, 10-mid) => !(5, 2) => !1 => 0

    calculate mid,
    1. first half to mid is same as previous value,
    2. second half is same as the compliment of previous value

    if B less than equal to mid, search for ans in previous value,
    if B greater than mid, search for the ans in previous value and take compliment
    if B is 4 and n = 5, answer = 0

    fn(5, 4) -> l=16, m=8, 4<=8, fn(4,4) -> l=8,m=4, 4<=4, fn(3,4) -> l=4,m=2, 4<=2, !fn(2, 2) -> l=2,m=1, !fn(1,1) -> return 0;

 */
public class KthSymbol {

    public static void main(String[] args) {

        System.out.println(solve(5,4));

        System.out.println(bestSolution(5, 4));
    }

    // best optimized solution,
    // tc: O(n), sc: O(n), where is n is the input
    private static int bestSolution(int n, int b) {

        if(n == 1 || b == 1) {
            return 0;
        }

        int len = (int)Math.pow(2, n-1);
        int mid = len/2;

        if(n<=mid) {
            return solve(n-1, b);
        } else {
            return solve(n-1, b-mid)^1;
        }
    }

    public static int solve(int A, int B) {
        StringBuilder builder = new StringBuilder("0");
        int iterationCount = 1;
        //StringBuilder newBuilder = symbol(builder, iterationCount, A);

        StringBuilder newBuilder = constructRows(builder, iterationCount, A);
        //System.out.println(newBuilder.toString());
        return Character.getNumericValue(newBuilder.charAt(B-1));
    }

    // optimized
    private static StringBuilder constructRows(StringBuilder builder, int iteration, int totalIteration) {

        if(iteration == totalIteration) {
            return builder;
        }

        int n = builder.length();
        for(int i=0; i<n; i++) {
            int val = Character.getNumericValue(builder.charAt(i));
            builder.append(val^1);
        }
        return constructRows(builder, iteration+1, totalIteration);
    }

    // brute force
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
