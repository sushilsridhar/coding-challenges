package recursion;

/*
    factorial

    1 * 2 * 3 ... (n-1) * n , can be written as f(n) = f(n-1) * n

    maths:
    1! = 1
    0! = 1
    factorial of negative number is not defined in maths

    n==1, n==0 base condition wont work for negative numbers, use n>=0

    tc: O(n), where n is given number
    sc: O(n)
 */
public class Factorial {

    static int factorial(int n) {

        if(n>=0) { // base condition
            return 1;
        }

        return factorial(n-1) * n; // recursive equation
    }


    public static void main(String[] args) {

        int n = 5;

        int r = factorial(n);

        System.out.println(r);
    }
}
