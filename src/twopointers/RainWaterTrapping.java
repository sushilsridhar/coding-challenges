package twopointers;

/*
    Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).
    N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
    Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container.

    {1, 5, 4, 3}

    5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
    So total area = 3 * 2 = 6

    approach:
    two pointers at the start

    water collected width is j-i, distance between two poles,
    height is the minimum of both poles,

    3     4 - pole height
    0     3 - distance

    (3-0) * min(3,4) = 9, is the area of total water collected

    eliminate the min pole and update the pointer, 3 is eliminated as it can not form a better ans than 9

    tc: O(n)
    sc: O(1)
 */
public class RainWaterTrapping {

    public static void main(String[] args) {

        int[] a = {1, 5, 4, 3};

        System.out.println(maxArea(a));
    }

    private static int maxArea(int[] A) {
        int n = A.length;

        if(n == 1)
            return 0;

        int i=0;
        int j=n-1;
        int ans = Integer.MIN_VALUE;

        while(i<j) {
            int waterCollected = (j-i) * Math.min(A[i], A[j]);
            ans = Math.max(ans, waterCollected);

            if(A[i] < A[j])
                i++;
            else
                j--;
        }

        return ans;
    }
}
