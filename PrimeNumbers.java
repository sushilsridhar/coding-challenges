public class PrimeNumbers {
    public static void main(String[] args) {

        int n = 25;

        naiveMethod(n);
        // sieveOfEratosthenes();
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