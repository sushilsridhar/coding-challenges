package maths.modulararthimetic;

import java.util.ArrayList;

/*
    Given a and b, a > b
    find the number of m such that, a%m = b%m  and m>1

    eg: a = 16, b = 4

    m = 2, 3, 4, 6, 12

    observation, m can't be greater than a

    optimization:

    a%m = b%m
    a%m - b%m = 0
    a%m - b%m + m = m
    (a%m - b%m + m)%m = m%m
    (a-b)%m = 0, this means, (a-b) is divisible by m
    and m is a factor of a-b,

    find the factors of a-b , refer numbers/Prime_Numbers
 */
public class FindNoOfM {
    public static void main(String[] args) {
        
        System.out.println(findNoOfM(16, 4));

        for(int i: optimized(16, 4)) {
            System.out.print(i+" ");
        }
    }

    // tc: O(sqrt(a-b))
    private static ArrayList<Integer> optimized(int a, int b) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = a-b;
        for(int i=2; i<=Math.sqrt(n); i++) { // given a > b
            if(n%i == 0) {
                list.add(i);
                list.add(n/i); // 12/4 = 3, 3 is factor, then 4 is also a factor, 12/4 = 3
            }
        }
        list.add(n); // because n is factor of n
        return list;
    }

    // tc: O(a)
    private static int findNoOfM(int a, int b) {
        int count = 0;
        for(int i=2; i<a; i++) {
            if(a%i == b%i) {
                count++;
            }
        }
        return count;
    }
}
