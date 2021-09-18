package numbers;

/*
    assume n is the perfect square

    Time complexity: root n not n
 */
public class Find_SQRT {
    public static void main(String[] args) {

        int n = 100;

        System.out.println(findSqrt(n));
    }

    private static int findSqrt(int n) {

        for(int i=1; i<=n; i++) {

            if(i*i == n) {
                return i;
            }
        }
        return 0;
    }
}
