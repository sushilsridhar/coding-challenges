package numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Time complexity o(a), where a is dividend.

    For a/b, a = b * q + r

    method two:  exp(log(a) – log(b)) = c
    Math.floor(sign *  (Math.exp(Math.log(dividend) -  Math.log(divisor)))));
*/
public class Divide_Without_Operators {

    public static void main(String []args) throws IOException {

        System.out.println("enter input");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());


        int q = 0;


        int sign = ((a < 0) ^ (b < 0)) ? -1 : 1;

        a = Math.abs(a);
        b = Math.abs(b);

        while(a>=b) {
            a = a - b;
            q++;
        }

        q = sign * q;

        System.out.println("q: "+q);
        System.out.println("r: "+a); // --> satisfies r = a - b * q, euclidean division
    }
}
