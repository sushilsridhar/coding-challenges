package reverse;

/*
    12345 divide by 10 gives 1234
    12345 mod 10 gives 5

    Time Complexity: o(log n) --> where n is input number (12,345), iteration count reduces exponentially
*/

public class ReverseInteger {
    public static void main(String []args) {

        int number = 12345;

        int results = 0, mod = 0;

        while(number!=0) {
            mod = number % 10;
            number = number/10;
            results = results * 10 + mod;
        }

        System.out.println(results);
    }
}
