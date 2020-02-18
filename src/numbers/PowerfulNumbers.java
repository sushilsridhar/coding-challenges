package numbers;

import java.util.ArrayList;

/*
    calculate Time complexity
*/
public class PowerfulNumbers {
    public static void main(String[] args) {

        int input = 36;

        getPrimeNumber(input);
    }

    public static void getPrimeNumber(int n) {

        ArrayList<Integer> list = new ArrayList<Integer>();
       // for(int i=2; )
        for(int i=2; i<=n; i++) {
            if(n%i == 0) {
                System.out.println(i);
                list.add(n);
            }
        }
    }
}