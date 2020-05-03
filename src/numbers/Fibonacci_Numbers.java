package numbers;

/*
    Time Complexity: o(n), where n is number of fibonacci numbers needed
 */

public class Fibonacci_Numbers {

    public static void main(String args[]) {

        int i = 0;
        int j = 1;
        int f = 0;

        int n = 9;
        int counter= 0;

        System.out.println(i);
        System.out.println(j);

        while(counter <= n - 2) {
            f = i + j;

            System.out.println(f);

            i = j;
            j = f;

            counter++;
        }
    }
}
