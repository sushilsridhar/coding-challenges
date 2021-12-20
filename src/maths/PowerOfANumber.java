package maths;

/*
    Modular Arithmetic,

    Modular Arithmetic Formula
    - (a + b) % M = (a%M + b%M) % M
    - (a * b) % M = (a%M * b%M) % M

    calculate (a^n)%p

    int a=10, n=40, p=7;
    10^40 is outside of integer range, solve using Modular Arithmetic
 */
public class PowerOfANumber {

    public static void main(String[] args) {

        //int a=2, n=5, p=7; // answer: 4

        int a=10, n=40, p=7;

        System.out.println(bestSolution(a,n,p));

    }

    private static long bestSolution(int a, int n, int p) {

        long ans=1; // alteast one of the two items to be multiplied should be long,
        // so that ALU inside CPU can create a long output register for storing the results of the product.

        for(int i=1;i<=n;i++) {
            ans = (ans * a) %p; // (ans * a) might come in range 10^18, so ans is initialized as long
        }

        return ans;
    }

    // causes overflow
    private static int power(int a, int n, int p) {

        int ans = 1;
        for(int i=1; i<=n; i++) {
            ans = ans * a;
        }
        return ans;
    }
}
