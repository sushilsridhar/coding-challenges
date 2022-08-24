package twopointers;

/*
    Given a sorted array of distinct integers A and an integer B,
    find and return how many rectangles with distinct configurations can be created
    using elements of this array as length and breadth whose area is lesser than B.

    (Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)

    {1, 2, 3, 4, 5} , b = 20

    1x1 1x2 1x3 1x4 1x5 (rectangles from i to j)
        2x1 3x1 4x1 5x1 (rectangeles from j to i)

        2x2 2x3 2x4 2x5
            3x2 4x2 5x2

            3x3 3x4 3x5
                4x3 5x3

                4x4

    ans - 22

    tc: O(n)
    sc: O(1)
 */
public class CountRectangles {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};

        System.out.println(twoPointers(a, 20));
    }

    private static int twoPointers(int[] A, int B) {
        int ans = 0;
        int mod = (int) Math.pow(10, 9) + 7;

        int i=0;
        int j=A.length-1;
        while(i<=j) {
            long area = (long)A[i] * A[j];

            if(area < B) {
                int totalRectanglesBetweenIandJ = j-i+1;
                int totalRectanglesBetweenJandI = totalRectanglesBetweenIandJ - 1;
                ans = (ans%mod + totalRectanglesBetweenIandJ%mod + totalRectanglesBetweenJandI%mod)%mod;
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }
}
