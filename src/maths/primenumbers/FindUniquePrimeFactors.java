package maths.primenumbers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
    algorithm: seive of eratosthenes

    Given a number n, find the unique prime factors of all numbers from 2 to n

    n = 12,

    2   3   4   5    6   7   8   9    10   11    12
    2   3   2   5   2,3  7   2   3   2,5   11   2,3 -> unique prime factors

    tc: O(n + n * log n)
    sc: O(n + n * primeFactors of n)
 */
public class FindUniquePrimeFactors {

    public static void main(String[] args) {

        HashMap<Integer, HashSet<Integer>> r = seiveOfEratosthenes(12);

        for(Map.Entry<Integer,HashSet<Integer>> entry : r.entrySet()) {
            System.out.print(entry.getKey()+ ": ");

            for(int i: entry.getValue()) {
                System.out.print(i+", ");
            }

            System.out.println("");
        }
    }

    private static HashMap<Integer, HashSet<Integer>> seiveOfEratosthenes(int n) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        boolean[] fabric = new boolean[n+1];
        fabric[1] = false;
        for(int i=2; i<=n; i++) {
            fabric[i] = true;
        }

        for(int i=2; i<=n; i++) {
            if(fabric[i]) {
                for(int j=i; j<=n; j=j+i) {
                    fabric[j] = false;
                    if(map.containsKey(j)) {
                        map.get(j).add(i);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(i);
                        map.put(j, set);
                    }
                }
            }
        }

        return map;
    }
}
