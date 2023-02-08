package arrays.numbers;

/*
    You are given an array of distinct integers A, you have to find and return the count of elements in array
    which have at-least one greater element than itself

    O(n)
 */
public class AtleastOneElementsGreater {
    public static void main(String[] args) {

        int[] a = {3, -2, 6, 8, 4, 8, 5};

        int[] b = {2, 3, 10, 7, 3, 10, 2, 10};

        System.out.print(solve(b));

    }

    private static int solve(int[] a) {

        int max = Integer.MIN_VALUE;
        int count = 0;

        for(int i=0; i<a.length; i++) {
            if(max < a[i]) {
                max = a[i];
                count = 0;
            }
            if(max == a[i]) {
                count++;
            }
        }

       /* for(int i=0; i<a.length; i++) {
            if(max == a[i]) {
                count++;
            }
        }*/
        return a.length - count;
    }
}
