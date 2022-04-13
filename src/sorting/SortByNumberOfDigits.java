package sorting;

import java.util.Arrays;
import java.util.Objects;

/*
    Given N array elements sort them in increasing order of their
    number of digits
    If two elements have the same number of digits, the element with more value should come first

    Note: no extra space is allowed

    93, 2, 37, 639, 8, 100, 345, 49
    2   1  2   3    1  3    3    2

    8  2  93  49  37  639  345  100 - output

    Java Comparator:
    How to sort an array of ints using a custom comparator?
    Comparator does not support primitives types, because generics does not supports primitives types

    We have two inputs, a and b
    comparator method should return

        1. positive when a is bigger,
        2. negative when a is smaller,
        3. zero when a and b are same

   Always think about a,
    if a is greater return 1, the sort function will place a at the last and b at the first (increasing order)
    if a is smaller return -1, the sort function will place a at the first and b at the last (increasing order)
    if a and b are same return 0, the sort function will take care of what to do
 */
public class SortByNumberOfDigits {

    public static void main(String[] args) {

        int[] A = { 93, 2, 37, 639, 8, 100, 345, 49 };

        int[] r = solution(A);
        for(int i=0; i<r.length; i++) {
            System.out.print(r[i] + " ");
        }
    }

    private static int[] solution(int[] arr) {

        Integer[] integerArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(integerArray, (a, b) -> {

            if(Objects.equals(a,b)) {
                return 0;
            } else {
                int aNoOfDigits = findNumberOfDigits(a);
                int bNoOfDigits = findNumberOfDigits(b);

                if(aNoOfDigits > bNoOfDigits) {
                    return 1;
                } else if(aNoOfDigits == bNoOfDigits && a > b) {
                    return -1;
                } else if(aNoOfDigits == bNoOfDigits) {
                    return 1;
                }
                return -1;
            }
        });

        int[] r = Arrays.stream(integerArray).mapToInt(ele->ele).toArray();

        return r;
    }

    private static int findNumberOfDigits(int ele) {
        int count = 0;
        while(ele>0) {
            count++;
            ele = ele/10;
        }
        return count;
    }
}
