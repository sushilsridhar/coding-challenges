package arrays.prefixsum;

/*
    Technique: Prefix Sum, use prefix sum only when there are multiple queries

    below solution only works if arr[] contains only 0, as initial value

    step1: For all queries, update arr[], update the value at start index and value at endIndex+1

           L R   X
           2-5   3  --> arr[2] = arr[2] + 3, arr[6] = arr[6] - 3
           3-7   2  --> arr[3]+= 2, arr[8]-= 2
           1-4  -4  --> arr[1]+= (-4), arr[5]-= (-4)
           5-8   1  --> arr[5]+= 1, arr[9]-= 1
           6-9  -3  --> arr[6]+= -3, arr[10] is not present so ignore

           new arr[] --> { 0, -4, 3, 2, 0, 5, -6, 0, -2, -1};

     step2: calculate prefix array for the new array

            pf[i] = pf[i-1] + a[i];
 */
public class AddXFromLeftToRightQueries {
    public static void main(String[] args) {


        // L R  X
        /* 2-5  3
           3-7  2
           1-4  -4
           5-8  1
           6-9  -3
         */

        int N = 5;
        int[][]D = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        // ans Return: [10, 55, 45, 25, 25]

        exampleBruteForce(N, D);

        exampleBestSolution(N, D);

    }

    private static int[] exampleBestSolution(int A, int[][] B) {
        int[] a = new int[A];
        int[] pf = new int[A];

        for(int i=0; i<B.length; i++) {
            int startIndex = B[i][0]-1;
            int endIndex = B[i][1]-1;
            int amountGiven = B[i][2];

            a[startIndex] += amountGiven;
            if((endIndex+1) <= a.length-1) {
                a[endIndex+1] -= amountGiven;
            }
        }

        pf[0] = a[0];
        for(int i=1; i<a.length; i++) {
            pf[i] = pf[i-1] + a[i];
        }

        return pf;
    }

    private static int[] exampleBruteForce(int A, int[][] B) {

        int[] a = new int[A];

        for(int i=0; i<B.length; i++) {
            int startIndex = B[i][0];
            int endIndex = B[i][1];
            int amountGiven = B[i][2];

            for(int j=startIndex-1; j<=endIndex-1; j++) {
                a[j] = a[j] + amountGiven;
            }
        }

        return a;

    }

    // time complexity: O(n+q), q - number of queries, n - calculate prefix array
    // space complexity: O(1), since the same array is used
    private static void bestSolution() {

        //pseudocode

        /* // O(q)
            while(q--) {
                arr[left]+= x
                if(right < n-1) {
                    arr[right]-= x;
                }
            }

            construct prefix array: keeping the same array for constructing the prefix array

            S=arr[0];
            i=1; i<N; i++
                s=s+arr[i]
                arr[i]=s;
         */

    }

    // time complexity: O(q*n), q - number of queries, n , qEnd-qstart-1, worst case qstart=0,
    // qEnd=n, --> n-1, space complexity: O(1)
    private static void bruteForce(int[] arr, int qStart, int qEnd, int x) {

        // iterate the below for loop for all queries
        //while(q--), qStart and qEnd will change
        for(int i = qStart; i<=qEnd; i++) {
            arr[i] = arr[i] + x;
        }
    }
}
