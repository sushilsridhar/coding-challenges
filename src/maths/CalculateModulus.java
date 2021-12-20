package maths;

/*
    Modular Arithmetic,

    Modular Arithmetic Formula
    - (a + b) % M = (a%M + b%M) % M
    - (a * b) % M = (a%M * b%M) % M

    Given N and p, calculate N%p

    constraints,
    1<=N<=10^100000,  this can be long , number of digits in the char
    1<=p<=10^9,       this is int range

    input, N is given in char[] or string, every char represents a digit
    3843689

    3,8,4,3,6,8,9
    3*10^6 + 8*10^5 + ..., taking modulus (3*10^6 + 8*10^5 + ...)%p, apply Modular Arithmetic Formula

    ((3*10^6)%p + (8*10^5)%p+ ...)%p -> ((3%p * 10^6%p)%p + (8%p * 10^5%p )%p+ ...)%p

    Ascii value of '0' is 48, use -48, or -any number to convert char to int

    x =  10^5%p, to get 10^6%p ->
    (10^5 * 10)%p
    (10^5%p *10%p)%p
    (x * 10%p)%p

    (a * b)%p = (a%p * b)%p = (a * b%p)%p = (a%p * b%p)%p

 */
public class CalculateModulus {

    public static void main(String[] args) {

        char[] n ={'3','8','4','3','6','8','9'};
        int p=7;

        System.out.println(solution(n,p));
        System.out.println(bestSolution(n,p));

        System.out.println(3843689%p);

        System.out.println(100%7*8);
        System.out.println(800%7);


    }

    // time complexity O(k) , where k is number of digits
    private static long bestSolution(char[] n, int p) {
        int k = n.length; // k is length of the char

        int r=1, ans=0;

        for(int i=k-1; i>=0; i--) {
            ans = ans + (n[i]-48) * r;
            r = (r * 10)%p;
            ans = ans%p;
        }

        return ans;
    }

    // time complexity O(k^2) ,  1<=N<=10^100000 , max value of k is 10^5, k2 ~ 10^10, TLE
    private static long solution(char[] n, int p) {
        int k = n.length; // k is length of the char

        long ans = 0;
        for(int i=0; i<k; i++) {
            ans = ans + ((n[i]-48)%p * powerFunction(10, k-1-i, p))%p; // power function O(k)
        }

        return ans%p;
    }

    // worst case time complexity: O(k)
    private static long powerFunction(int a, int n, int p) {

        long ans=1; // alteast one of the two items to be multiplied should be long,
        // so that ALU inside CPU can create a long output register for storing the results of the product.

        for(int i=1;i<=n;i++) {
            ans = (ans * a) %p; // (ans * a) might come in range 10^18, so ans is initialized as long
        }

        return ans;
    }
}
