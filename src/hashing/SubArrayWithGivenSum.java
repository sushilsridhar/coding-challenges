package hashing;

import java.util.ArrayList;

/*
    Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
    If the answer does not exist return an array with a single element "-1".
    First sub-array means the sub-array for which starting index in minimum.

                0  1  2  3  4
     int[] A = {1, 2, 3, 4, 5};
     ans -> [2, 3] adds to 5

     ans -> [2, 3, 4] adds to 9

    tc: O(n) , sc: O(n)

    the two pointers individually traverse the each element of the array only once, so it is O(n+n)
    O(2n) -> O(n)
 */
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 5;

        int[] r = bruteForce(A, B);
        for(int ele: r) {
            System.out.print(ele+" ");
        }

        System.out.println("");

        int[] C = {1, 2, 3, 4, 5};

        int[] r1 = twoPointerSolution(C, 9);
        for(int ele: r1) {
            System.out.print(ele+" ");
        }
        System.out.println("");

        int[] D = {1, 2, 3, 4, 5};

        int[] r2 = prefixSumWithTwoPointer(D, 9);
        for(int ele: r2) {
            System.out.print(ele+" ");
        }

        System.out.println("");

        int[] E = {1, 2, 3, 4, 5};

        int[] r3 = twoPointerCarryForwardTechnique(E, 9);
        for(int ele: r3) {
            System.out.print(ele+" ");
        }

    }

    // tc: O(n) , sc: O(n)
    public static int[] prefixSumWithTwoPointer(int[] A, int B) {
        ArrayList<Integer> r = new ArrayList<>();

        int n = A.length;
        int pointer1 = 0;
        int pointer2 = 0;
        boolean ansFound = false;

        int[] pf = new int[n];
        int pfSum = 0;
        for(int i=0; i<n; i++) {
            pfSum = pfSum + A[i];
            pf[i] = pfSum;
        }

        while(pointer1 <= n-1 && pointer2 <= n-1) {

            int sum = pf[pointer2] - pf[pointer1] + A[pointer1];

            if(sum == B) {
                ansFound = true;
                break;
            } else if(sum > B) {
                if(pointer1 == pointer2) {
                    pointer2++;
                }
                pointer1++;
            } else if(sum < B) {
                pointer2++;
            }
        }

        if(ansFound) {
            for(int i=pointer1; i<=pointer2; i++) {
                r.add(A[i]);
            }
            return r.stream().mapToInt(ele->ele).toArray();
        }

        return new int[]{-1};
    }

    // tc: O(n) , sc: O(n)
    private static int[] twoPointerCarryForwardTechnique(int[] A, int B) {
        ArrayList<Integer> r = new ArrayList<>();

        int n = A.length;
        boolean ansFound = false;

        int pointer1 = 0;
        int pointer2 = 0;
        int sum = A[pointer1];

        while(pointer1 <= n-1 && pointer2 <= n-1) {

            if(sum == B) {
                ansFound = true;
                break;
            } else if(sum > B) {
                if(pointer1 == pointer2) {
                    pointer2++;
                    if(pointer2 <= n-1) {
                        sum = sum + A[pointer2];
                    }
                }
                sum = sum - A[pointer1];
                pointer1++;
            } else if(sum < B) {
                pointer2++;
                if(pointer2 <= n-1) {
                    sum = sum + A[pointer2];
                }
            }
        }

        if(ansFound) {
            for(int i=pointer1; i<=pointer2; i++) {
                r.add(A[i]);
            }
            return r.stream().mapToInt(ele->ele).toArray();
        }

        return new int[]{-1};
    }

    // tc: O(n * n) , sc: O(n)
    private static int[] twoPointerSolution(int[] A, int B) {
        ArrayList<Integer> r = new ArrayList<>();

        int n = A.length;
        int pointer1 = 0;
        int pointer2 = 0;
        boolean ansFound = false;


        while(pointer1 <= n-1 && pointer2 <= n-1) {
            int sum = 0;

            for(int i=pointer1; i<=pointer2; i++) {
                sum = sum + A[i];
            }

            if(sum == B) {
                ansFound = true;
                break;
            } else if(sum > B) {
                if(pointer1 == pointer2) {
                    pointer2++;
                }
                pointer1++;
            } else if(sum < B) {
                pointer2++;
            }
        }

        if(ansFound) {
            for(int i=pointer1; i<=pointer2; i++) {
                r.add(A[i]);
            }
            return r.stream().mapToInt(ele->ele).toArray();
        }

        return new int[]{-1};
    }

    // tc: O(n^2) , sc: O(n)
    public static int[] bruteForce(int[] A, int B) {
        ArrayList<Integer> r = new ArrayList<>();

        for(int i=0; i<A.length; i++) {
            int sum = 0;
            for(int j=i; j<A.length; j++) {
                sum = sum + A[j];
                if(sum == B) {
                    for(int k=i; k<=j; k++) {
                        r.add(A[k]);
                    }
                    return r.stream().mapToInt(ele->ele).toArray();
                } else if(sum > B) {
                    break;
                }
            }
        }

        return new int[]{-1};
    }
}
