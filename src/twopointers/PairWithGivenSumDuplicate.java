package twopointers;

import java.util.HashMap;

/*
    Given a sorted array of integers (not necessarily distinct) A and an integer B,
    find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

    Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).

    approach:
    frequency map, a + b = c, a = c-b,

    a = c - b (value from array), if you find a in map, the freq of a is the count of pairs
    decrement b value from the map, so that we do not process again when a becomes b

    2 freq - 2
    7-2 = 5, count is 2 , ( 2,5 2,5) two pairs found

    when processing 5, 7-5 =2, (5,2 5,2) duplicate processing, can be avoided by decrementing 2 value from freq map

    two pointers,

    one pointer at start and another pointer at last,
    0 1 2 3 4 5 6 7
    1 2 2 4 5 6 6 8 , b = 7

    i = 0, j = 6, 1 + 6 = 7,
    count number of 1s and 6s, count = count + a * b

    0 1 2 3
    2 2 2 2, b = 4,

    i=0, j=3, totalElements is 4, selecting 2 out of 4, NC2 , 4C2,
    formula, 4*(4-1)/2 = 6,
    now break the loop, do not move to next 2 for i and j

    tc: O(n)
    sc: O(1)

 */
public class PairWithGivenSumDuplicate {

    public static void main(String[] args) {

        int[] a = {1, 2, 2, 4, 5, 6, 6, 8};

        System.out.println(usingFreqMap(a, 7));
        System.out.println(twoPointers(a, 7));

    }

    private static int twoPointers(int[] A, int B) {

        int mod = 1000 * 1000 * 1000 + 7;
        int count = 0;

        int i=0;
        int j=A.length-1;

        while(i<j) {
            int sum = A[i] + A[j];

            if(sum == B) {
                if(A[i] == A[j]) {
                    int totalElements = j - i + 1;
                    int n = totalElements;
                    long selectingTwoOutOfN = (long)n * (n-1)/2;
                    count = (int)(count%mod + selectingTwoOutOfN%mod)%mod;
                    break;
                } else {
                    int countOfAOfI = 1;
                    while(A[i] == A[i+1]) {
                        countOfAOfI++;
                        i++;
                    }
                    int countOfAOfJ = 1;
                    while(A[j] == A[j-1]) {
                        countOfAOfJ++;
                        j--;
                    }
                    long totalPairs = (long)countOfAOfI * countOfAOfJ;
                    count = (int)(count%mod + totalPairs%mod)%mod;
                }
                i++;
                j--;
            } else if(sum > B) {
                j--;
            } else if(sum < B) {
                i++;
            }
        }

        return count;
    }

    private static int usingFreqMap(int[] A, int B) {

        int mod = (int) Math.pow(10,9) + 7;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<A.length; i++) {
            if(map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i])+1);
            } else {
                map.put(A[i], 1);
            }
        }

        for(int i=0; i<A.length; i++) {
            int x = B - A[i];
            if(map.containsKey(x) && map.get(x) > 0) {

                if(A[i] == x)
                    count = (int) (((long)count%mod + (map.get(x)-1)%mod)%mod);
                else
                    count = (int) (((long)count%mod + map.get(x)%mod)%mod);


                map.put(A[i], map.get(A[i])-1);
            }
        }
        return count;
    }
}
