package arrays.queries;

/*
    Technique: Prefix Sum

    1. calculate prefix array for all elements
       pf[0] - sum of all elements from 0-0
       pf[1] - sum of all elements from 0-1
       pf[7] - sum of all elements from 0-7

    2.  sum = pfArray[right] - pfArray[left] + arr[left];

    eg query 1-3,  pfArray[3] - pfArray[1] + arr[1];

    pfArray[left] -> pfArray[1], contains sum of all elements form 0-1
    pfArray[right] -> pfArray[3], contains sum of all elements from 0-3

    pfArray[right] - pfArray[left] --> contains sum of all elements from 2-3
    add the element missed out in subtraction, which is arr[left]--> arr[1]
 */
public class SumOfAllElementFromLeftToRightQueries {

    public static void main(String[] args) {

        int arr[] = {-3, 6, 2, 4,  5, 2,  8,  -9, 3,  1};
        // pfarray ={-3, 3, 5, 9, 14, 16, 24, 15, 18, 19}

        /*
            Queries,  sum
            1-3 , 12
            2-7, 12
            4-8, 9
            0-4, 14
            7-7, -9
         */

        System.out.println(bruteForce(arr, 1, 3));

        System.out.println(bestSolution(arr, 1, 3));

    }

    // time complexity: O(n+q), q - number of queries, n - calculate prefix array
    // space complexity: O(n), prefix array creation
    private static int bestSolution(int[] arr, int qStart, int qEnd) {

        int[] pfArray = new int[arr.length];
        int sum = 0;

        pfArray[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            pfArray[i] = pfArray[i-1] + arr[i];
        }

        // queries will be in arrays instead of integers, which is not coded here
        sum = pfArray[qEnd] - pfArray[qStart] + arr[qStart];
        return sum;

    }

    // time complexity: O(q*n), q - number of queries, n , qEnd-qstart-1, worst case qstart=0,
    // qEnd=n, --> n-1, space complexity: O(1)
    private static int bruteForce(int[] arr, int qStart, int qEnd) {

        int sum = 0;

        for(int i = qStart; i<=qEnd; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

}
