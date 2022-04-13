package sorting;

import java.util.Arrays;
import java.util.Objects;

/*
    Given a array A of non negative integers, arrange them such that they form the largest number.

    Note: The result may be very large, so you need to return a string instead of an integer.

    A = [3, 30, 34, 5, 9]
    "9534330" - output

    "3" + "30" --> "330"
    "30" + "3" --> "303"

    330 > 303, which means, 3 should come first in the array and 30 should come after 3 in the array
    a is 3, b is 30, return -1, so that sort function places a in the front of the array

    edge case, if [0,0,0,0] return [0], skip all leading zeros
 */
public class LargestNumber {

    public static void main(String[] args) {

        int[] A = { 93, 2, 37, 639, 8, 100, 345, 49 };

        System.out.println(solution(A));
    }

    private static String solution(int[] A) {

        String r = "";
        String[] strArray = new String[A.length];
        for(int i=0; i<A.length; i++) {
            strArray[i] = Integer.toString(A[i]);
        }

        Arrays.sort(strArray, (a, b) -> {

            if(Objects.equals(a,b)) {
                return 0;
            } else {
                String ab = a + b;
                String ba = b + a;

                if(Long.parseLong(ab) > Long.parseLong(ba)) {
                    return -1;
                }
            }
            return 1;
        });

        boolean firstNonZeroElementFound = false;
        for(int i=0; i<strArray.length-1; i++) {    // length-1 --> edge case

            if(Objects.equals(strArray[i],"0") && !firstNonZeroElementFound) {
                continue;
            } else {
                firstNonZeroElementFound = true;
            }
            r = r + strArray[i];
        }

        r = r + strArray[strArray.length-1]; // edge case

        return r;
    }
}
