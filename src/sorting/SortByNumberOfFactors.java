package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/*
    Given N array elements sort them in increasing order of their
    number of factors
    If two elements have the same factor, the element with less value should come first

    Note: no extra space is allowed

    [ 9, 3, 4, 8, 16, 37, 6, 13, 15]
      3  2  3  4  5   2   4  2   4  - factors

    [3, 13, 37, 4, 9, 6, 8, 15, 16] - output

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
public class SortByNumberOfFactors {

    public static void main(String[] args) {

        int[] A = { 9, 3, 4, 8, 16, 37, 6, 13, 15 };

        int[] r = solution(A);
        for(int i=0; i<r.length; i++) {
            System.out.print(r[i] + " ");
        }
    }

    private static int[] solution(int[] arr) {

        // using lambda
        int[] r = Arrays.stream(arr)
                .boxed()
                .sorted((a,b) -> {
                    if(Objects.equals(a, b)) {
                        return 0;
                    } else {
                        int aFactorsCount = numberOfFactors(a);
                        int bFactorsCount = numberOfFactors(b);

                        if(aFactorsCount > bFactorsCount) {
                            return 1;
                        } else if(aFactorsCount == bFactorsCount && a > b) {
                            return 1;
                        }
                    }
                    return -1;
                })
                .mapToInt(ele -> ele)
                .toArray();

        // old school conversion
        Integer[] integerArrayOldSchool = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integerArrayOldSchool[i] = arr[i];
        }

        // java 8 int[] to Integer[] conversion
        Integer[] integerArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // using anonymous inner class
        Arrays.sort(integerArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {

                if(Objects.equals(a, b)) {
                    return 0;
                } else {
                    int aFactorsCount = numberOfFactors(a);
                    int bFactorsCount = numberOfFactors(b);

                    if(aFactorsCount > bFactorsCount) {
                        return 1;
                    } else if(aFactorsCount == bFactorsCount && a > b) {
                        return 1;
                    }
                }
                return -1;
            }
        });

        // old school conversion
        int[] intArrayOldSchool = new int[integerArrayOldSchool.length];
        for (int i = 0; i < integerArrayOldSchool.length; i++) {
            intArrayOldSchool[i] = integerArrayOldSchool[i];
        }

        // java 8 Integer[] to int[] conversion
        int[] r1 = Arrays.stream(integerArray).mapToInt(ele->ele).toArray();

        return r;
    }

    private static int numberOfFactors(int a) {
        int count = 0;
        for(int i=1; i<=a; i++) {
            if(a%i == 0) {
                count++;
            }
        }
        return count;
    }
}
