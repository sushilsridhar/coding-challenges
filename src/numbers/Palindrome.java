package numbers;

/*
   Time complexity, o(n), where n is the number of digits in number
 */
public class Palindrome {

    public static void main(String[] args) {

        int n = 2002;

        int number = n;

        int r = 0;
        int reverse = 0;

        while(n > 0) {

            r = n%10;

            reverse = reverse * 10 + r;

            n = n/10;
        }

        System.out.println(reverse);

        if(reverse == number) {
            System.out.println("Palindrome");
        }
        else {
            System.out.println("Not a palindrome");
        }
    }
}
