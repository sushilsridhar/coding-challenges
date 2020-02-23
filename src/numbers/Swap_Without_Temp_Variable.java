package numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swap_Without_Temp_Variable {
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("enter a: ");
        int a = Integer.parseInt(reader.readLine());

        System.out.println("enter b: ");
        int b = Integer.parseInt(reader.readLine());

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("Swapped numbers: "+ a +" "+b);
    }
}
