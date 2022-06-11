package arrays.subarrays;

/*
    technique: contribution technique
               adding contribution of each and every element
                0   1  2   3  4  5
    int a[] = { 3, -2, 4, -1, 2, 6};

    in how many subarrays index 3 element is present,

    left side   right side  --> all combination, leftside * rightside, 4*3= 12
        0           3
        1           4
        2           5
        3

    arr[] = { a0, a1, a2, a3, a4, a5, a i... a n-1}

    in how many subarrays a i is present,
    left side - [0 to i], i-0+1 -> i+1
    right side - [i to N-1], N-1-i+1 -> N-i

    left side * right side -> gives total numbers of subarrays in which a i is present

    a[i] * leftside * rightside -> gives the total count of a[i] in all subarrays,
    in the subarrays together, a[i] is occuring leftside * rightside times

 */
public class TotalSumOfAllSubArrays {

    public static void main(String[] args) {

        int a[] = { 3, -2, 4, -1, 2, 6};

        bruteforce(a); // O(n^3)
        efficient(a);  // O(n)

    }

    private static void efficient(int[] a) {

        int N = a.length;
        int sum = 0;

        for(int i=0; i<N; i++) {
            int leftside = i+1;
            int rightside = N-i;

            int total = leftside * rightside;

            sum = sum + total * a[i];
        }
        System.out.println("sum of all subarrays: "+sum);
    }

    private static void bruteforce(int[] a) {

        int len = a.length;

        int sum = 0;
        for(int i=0; i<len; i++) {
            for(int j=i; j<len; j++) {
                for(int k=i; k<=j;k++) {
                    sum = sum + a[k];
                }
            }
        }
        System.out.println("sum of all subarrays: "+sum);
    }
}
