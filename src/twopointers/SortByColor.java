package twopointers;

/*
    Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.

    Note: Using the library sort function is not allowed.

    approach:
    use two pointers, one pointer to track the next position of 1 and another pointer to track the next position of 2,
    1 will align itself automatically

    tc: O(n)
    sc: O(1)
 */
public class SortByColor {

    public static void main(String[] args) {

        int[] a = {0, 1, 2, 0, 1, 2};

        int[] r = twopointers(a);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }

    private static int[] twopointers(int[] A) {

        int zero = 0;
        int two = A.length-1;
        int i=0;
        while(i<=two) {
            if(A[i] == 0) {
                A[i] = A[zero];
                A[zero] = 0;
                zero++;
                i++;
            } else if(A[i] == 2) {
                A[i] = A[two];
                A[two] = 2;
                two--;
            } else {
                i++;
            }
        }
        return A;
    }

    public int[] sortColors(int[] A) {

        int[] ans = new int[A.length];
        int white = 0;
        int red = 0;
        int blue = 0;
        for(int i=0; i<A.length; i++) {
            if(A[i] == 0)
                red++;
            if(A[i] == 1)
                white++;
            if(A[i] == 2)
                blue++;
        }

        int i = 0;
        while(red > 0 || white > 0 || blue > 0) {
            if(red > 0) {
                ans[i] = 0;
                red--;
                i++;
            } else if(white > 0) {
                ans[i] = 1;
                white--;
                i++;
            } else if(blue > 0) {
                ans[i] = 2;
                blue--;
                i++;
            }
        }
        return ans;
    }
}
