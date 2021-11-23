package arrays.subarrays;

/*
    Given sum of all elements from
    [2,5] is x
    [2,6] is x + arr[6]

    Carry forward technique
 */
public class SumOfAllSubArrayElements {

    public static void main(String[] args) {

        int a[] = { 3, -2, 6, 4, 2};

        bruteForce(a); //O(n^2)
        System.out.println("----");
        efficient(a);
    }

    private static void efficient(int[] a) {

        for(int i=0; i<a.length; i++) {
            int sum=0;
            for(int j=i; j<a.length; j++) {
                //[i-j] is a subarray
                sum = sum + a[j];
                System.out.println("Sum of sub array from "+i+" to "+j+" = "+sum);
            }
        }
    }

    private static void bruteForce(int[] a) {
        for(int i=0; i<a.length; i++) {
            for(int j=i; j<a.length; j++) {
                int sum=0;
                for(int k=i; k<=j;k++) { // [i-j] is a subarray
                    sum = sum + a[k];
                }
                System.out.println("Sum of sub array from "+i+" to "+j+"="+sum);
            }
        }
    }
}
