package numbers;

/*
    Time complexity: 0(n) , where n is the number of digits in the number
 */
public class Armstrong_Numbers {

    public static void main(String []args) {

        int n = 1634;

        int number = n;
        int mod = 0;
        int results = 0;

        int count = 0;

        int n_copy = n;

        while( n_copy > 0) {
            n_copy = n_copy/10;
            count++;
        }


        while(n > 0) {

            mod = n%10;

            n = n/10;

            results = results + pow(mod, count); // can use Math.pow here
        }

        if(results == number) {
            System.out.println("Arsmstrong number");
        }
        else {
            System.out.println("Not an Armstrong number");
        }
    }

    static int pow(int num, int count) {

        int results = 1;

        while(count > 0 ) {

            results = results * num;

            count--;
        }

        return results;
    }
}
