package gfg;

/*
    o(n), where n is number of digits in the number
 */
public class Convertfive {

    static int convertfive(int num) {
        int result = 0, count = 1, mod = 0;
        while(num!=0) {
            mod = num%10;
            num = num/10;

            if(mod == 0) {
                mod = 5;
            }
            result = result + mod * count;
            count = count *10;
        }

        return result;
    }

    static int convertFiveRecursion(int num) {

        if(num==0) {
            return num;
        } else {
            return recursion(num);
        }
    }

    private static int recursion(int num) {

        if(num == 0) return 0;

        int mod = num%10;

        if (mod == 0) mod = 5;

        num = num/10;

        return recursion(num) * 10 + mod;
    }

    public static void main(String[] args) {
        System.out.println(convertfive(1004));
        System.out.println(convertFiveRecursion(1004));
    }
}

/*

1004,

(100) * 10 + 4

(10)  * 10 + 0 (5)

(1)   * 10 + 0 (5)

(0)   * 10 + 1
 */