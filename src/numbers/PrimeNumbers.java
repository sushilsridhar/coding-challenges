package numbers;

import java.util.ArrayList;
import java.util.List;

/*
    calculate Time complexity
*/

public class PrimeNumbers {
    public static void main(String[] args) {

        int n = 25;

        // naiveMethod(n);
        sieveOfEratosthenes(n);
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

    static void sieveOfEratosthenes(int n) {
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 2; i<=n; i++) {
            list.add(i);
        }

        int i = 2;
        for(int j = 4; j<=n; j++) {
            if(j%i == 0) {
                //list.remove();
            } 
        }
    }
}