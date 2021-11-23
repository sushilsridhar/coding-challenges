package arrays.subarrays;

public class PrintSubArrays {
    public static void main(String[] args) {

        int a[] = { 3, -2, 6, 4, 2};

        for(int i=0; i<a.length; i++) {
            for(int j=i; j<a.length; j++) {
                for(int k=i; k<=j;k++) { // [i-j] is a subarray
                    System.out.print(a[k]+ " ");
                }
                System.out.println(" ");
            }
        }
    }
}
