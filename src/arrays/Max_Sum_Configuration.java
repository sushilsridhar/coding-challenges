package arrays;

public class Max_Sum_Configuration {

    public static void main(String[] args) {

       int[] a = {8, 3, 1, 2};

       //int result = bruteForce(a, a.length);

        int result = bestSolution(a, a.length);

        System.out.println(result);
    }

    private static int bestSolution(int[] a, int n) {

        int sum = 0;

        int max = Integer.MIN_VALUE, maxIndex = 0;

        for(int i=0; i<n; i++) {
            if(a[i] > max) {
                max=a[i];
                maxIndex = i;
            }
        }

        int numberOfShifts = maxIndex+1; /* since shifts are based on array index, add +1 */

        reverseArray(a, 0, n-1);
        reverseArray(a, 0, n - 1 - numberOfShifts);
        reverseArray(a, n - numberOfShifts, n-1);


        for(int j=0; j<n; j++) {
            sum = sum + a[j] * j;
        }

        return sum;
    }

    private static void reverseArray(int[] a, int start_index, int end_index) {

        for(int i=start_index; i<end_index; i++, end_index--) {
            int temp = a[i];
            a[i] = a[end_index];
            a[end_index] = temp;
        }
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
