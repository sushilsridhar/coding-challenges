package recursion;

/*
    Given a number N, print all the numbers from 1 to N in increasing order
 */
public class PrintInIncreasingOrder {

    private static void recursive(int n) {

        if(n==0) {
            return;
        }

        recursive(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {

        int n = 10;

        recursive(n);
    }
}
