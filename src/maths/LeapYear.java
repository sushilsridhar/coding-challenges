package maths;

/*
    Given an integer A representing an year, Return 1 if it is a leap year else return 0.

    A year is leap year if the following conditions are satisfied:

    Year is multiple of 400
    OR
    Year is multiple of 4 and not multiple of 100.
 */
public class LeapYear {
    public static void main(String[] args) {

        int  A = 2020;
        System.out.println(solve(A));
    }

    public static int solve(int A) {

        if((A%400==0) || ((A%4==0) && (A%100!=0))) {
            return 1;
        }

        return 0;
    }
}
