package arrays.subarrays;
/*
   Find subarray start and end index of length k
 */
public class PrintStartAndEndIndex {
    public static void main(String[] args) {
                //  0  1  2   3  4  5  6  7  8  9  10  11
        int a[] = { 3, 4, 2, -1, 6, 7, 8, 9, 3, 2, -1, 4};

        int N = a.length;
        int k = 6;

        for(int i=0; i<N-k; i++) {
            int j = k-1 + i;
            System.out.println(i+" "+j);
        }
    }
}
