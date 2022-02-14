package hashing;

import java.util.HashMap;
import java.util.Map;

/*
    Groot has N trees lined up in front of him where the height of the i'th tree is denoted by H[i].
    He wants to select some trees to replace his broken branches.
    But he wants uniformity in his selection of trees.
    So he picks only those trees whose heights have frequency K.
    He then sums up the heights that occur K times. (He adds the height only once to the sum and not K times).
    But the sum he ended up getting was huge so he prints it modulo 10^9+7.
    In case no such cluster exists, Groot becomes sad and prints -1.

    Constraints:
    1.   1<=N<=100000
    2.   1<=K<=N
    3.   0<=H[i]<=10^9

    input: Integers N and K and array of size A
    Output: Sum of all numbers in the array that occur exactly K times.

    Example:
    Input:
    N=5 ,K=2 ,A=[1 2 2 3 3]
    Output:
    5
    Explanation:
    There are 3 distinct numbers in the array which are 1,2,3.
    Out of these, only 2 and 3 occur twice. Therefore the answer is sum of 2 and 3 which is 5.

    Map.Entry<Integer,Integer> ele: map.entrySet() -> use entry set for iteration
 */
public class GrootKOccurrences {

    public static void main(String[] args) {

        int[] a = {1,2,2,3,3}; // answer 2+3 = 5
        int N=5, B=2;

        System.out.println(optimized(N, B, a));
    }

    // tc: o(n+n), sc: O(n)
    public static int optimized(int A, int B, int[] C) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int ele: C) {
            if(map.containsKey(ele)) {
                map.put(ele, map.get(ele)+1);
            } else {
                map.put(ele, 1);
            }
        }

        int sum = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        boolean noClusterExists = true;

        for(Map.Entry<Integer,Integer> ele: map.entrySet()) {
            if(ele.getValue() == B) {
                sum = (sum%mod + ele.getKey()%mod)%mod;
                noClusterExists = false;
            }
        }

        if(noClusterExists) {
            return -1;
        }

        return sum;
    }
}
