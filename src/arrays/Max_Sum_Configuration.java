package arrays;

public class Max_Sum_Configuration {

    public static void main(String[] args) {

       int[] a = {8, 3, 1, 2};

       int result = bruteForce(a, a.length);

       System.out.println(result);
    }

    /*  o(n2) , where n is the size of the array */
    private static int bruteForce(int a[], int n)
    {
        int max_sum = Integer.MIN_VALUE, number_of_shifts = n;

        for(int i=0; i< number_of_shifts; i++) {

            /* shift the elements */
            int firstElement = a[0];
            for(int j=0; j<n-1; j++) {
                a[j] = a[j+1];
            }
            a[n-1] = firstElement;

            /* calculate the sum for each array ( each shift -> new array) */
            int sum = 0;
            for(int k=0; k<n; k++) {
                sum = sum + a[k] * k;
            }

            if(sum > max_sum) {
                max_sum = sum;
            }
        }

        return max_sum;
    }
}
