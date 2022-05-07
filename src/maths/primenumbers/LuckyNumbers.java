package maths.primenumbers;

import java.util.HashMap;
import java.util.Map;

/*
    algorithm: seive of eratosthenes

    A lucky number is a number that has exactly 2 distinct prime divisors.

    You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).

    A = 12

    Between [1, 12] there are 3 lucky number: 6, 10 and 12.

    6 is divisble by two prime numbers 2 and 3
    10, 2 and 5
    12, 2 and 3

    ans = 3

    tc: O(n * logn)
    sc: O(n)
 */
public class LuckyNumbers {

    public static void main(String[] args) {

        System.out.println(bruteForce(12));

        System.out.println(sieveOfEratosthenes(20));
    }

    // tc: O(A + A * logA + A)
    // sc: O(A + A)
    private static int sieveOfEratosthenes(int A) {
        int luckyNumberCount = 0;

        boolean[] fabric = new boolean[A+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        fabric[1] = false;
        for(int i=2; i<=A; i++) {
            fabric[i] = true;
        }

        for(int i=2; i<=A; i++) {
            if(fabric[i]) {
                for(int j=i*2; j<=A; j=j+i) {
                    fabric[j] = false;
                    if(map.containsKey(j)) {
                        map.put(j, map.get(j)+1);
                    } else {
                        map.put(j,1);
                    }
                }
            }
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getValue() == 2) {
                luckyNumberCount++;
            }
        }

        return luckyNumberCount;
    }

    // tc: O( A + A * logA + TODO)
    private static int bruteForce(int A) {
        int luckyNumberCount = 0;

        boolean[] fabric = new boolean[A+1];
        fabric[1] = false;
        for(int i=2; i<=A; i++) {
            fabric[i] = true;
        }

        for(int i=2; i<=A; i++) {
            if(fabric[i]) {
                for(int j=i*2; j<=A; j=j+i) {
                    fabric[j] = false;
                }
            }
        }

        for(int i=2; i<=A; i++) {
            int count = 0;
            for(int j=2; j<=i/2; j++) {

                if(i%j == 0 && fabric[j]) {
                    count++;
                }
            }

            if(count == 2) {
                luckyNumberCount++;
            }
        }

        return luckyNumberCount;
    }
}
