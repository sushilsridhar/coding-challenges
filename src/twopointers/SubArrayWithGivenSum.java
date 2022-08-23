package twopointers;

/*
    Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
    If the answer does not exist return an array with a single element "-1".
    First sub-array means the sub-array for which starting index in minimum.

    A = [1, 2, 3, 4, 5]
    B = 5

    ans -> [2, 3]

    approach:
    two pointers at the start

    tc: O(n)
    sc: O(1)
 */
public class SubArrayWithGivenSum {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};

        int[] r = solve(a, 5);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }

    public static int[] solve(int[] A, int B) {
        int n = A.length;
        int i = 0;
        int j = 0;
        int sum = A[0];

        while(i<n && j<n) {

            if(sum == B) {
                break;
            } else if(sum > B) {
                sum = sum - A[i];
                i++;
            } else if(sum < B) {
                j++;

                if(j<n) {
                    sum = sum + A[j];
                }
            }
        }

        if(i==n || j==n) {
            return new int[]{-1};
        }

        int[] r = new int[j-i+1];
        int index = 0;
        for(int k=i; k<=j; k++) {
            r[index] = A[k];
            index++;
        }

        return r;
    }
}
