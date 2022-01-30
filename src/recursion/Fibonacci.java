package recursion;

/*
    N  0  1  2  3  4  5   6  7  8
    f  1  1  2  3  5  8  13 21 34

    fib(4) = fib(3) + fib(2)

    Time complexity:

    assume both as, fib(n-1) + fib(n-1) in equation

    Recursive relation is given
    t(n) = 2t(n-1) + 1

    t(n) = 2(2t(n-2) + 1) + 1,
    t(n) = 4 t(n-2) + 3
    t(n) = 4(2t(n-3) + 1) + 3,
    t(n) = 8t(n-3) + 7 ---> t(n) = 2^3 t(n-3) + 2^3 -1
    after k steps,

    t(n) = 2^3 t(n-3) + 2^3 -1
    t(n) = 2^k t(n-k) + 2^k -1 --> if k=n, t(n) = 2^n t(0) + 2^n -1
    t(n) = 2^n
 */
public class Fibonacci {

    private static int fib(int n) {

        if(n==0 || n==1) {
            return 1;
        }

        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {

        int n = 4;

        int r = fib(n);

        System.out.println(r);
    }
}
