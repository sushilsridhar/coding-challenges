package arrays.subarrays;

public class TotalSumOfAllSubArrays {

    public static void main(String[] args) {

        int a[] = { 3, -2, 4, -1, 2, 6};

        bruteforce(a); // O(n^2)
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
