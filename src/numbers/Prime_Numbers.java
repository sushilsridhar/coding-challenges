package numbers;

/*
    prime number - it has only two factors 1 and itself

    If number N is prime number, it has no factors from 2 to root N

    a * b = n, a and b are two factors (a,b)
    a, n/a, (a, n/a) are factors
    i, n/i

    i < = n/i, after i > n/i , the factors will start repeating itself for eg, n =100, i=4, n%i == 0, 25
    again in the loop, when i becomes 25, n%i==0 , (i=25, 4) -> duplication of factors while iterating

    min value of i, 1
    max value of i, i = n/i -> i = root n , iterate the loop until root n

*/

public class Prime_Numbers {
    public static void main(String[] args) {

        int n = 2;

        // naiveMethod(n);

        System.out.println(isPrime(n));
    }

    private static String isPrime(int n) {

        if(n == 1)
            return "not prime";
        if(n == 2)
            return "not prime";

        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i == 0) {
                return "not prime";
            }
        }
        return "prime";
    }

    static void naiveMethod(int n) {
        for(int i=2; i<=n; i++) {
             int count = 0;

             for(int j=2; j<=i; j++) {
                    if(i%j == 0) {
                       count++;
                    }
                }
            if(count == 1 ) {
                 System.out.println(i);
            }    
        }
    }
}