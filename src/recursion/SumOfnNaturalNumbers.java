package recursion;

/*
    sum of n natural numbers

    1 + 2 + 3 ... (n-1) + n , can be written as sum(n) = sum(n-1) + n

    Time complexity:

    sum(n) = n + sum(n-1)

    recursive relation
    t(n) = 1 + t(n-1)

    t(n) = 1 + ( 1 + t(n-2)) , t(n-1) = 1 + t(n-2)
    t(n) = 2 + t(n-2)
    t(n) = 3 + t(n-3), after k steps, t(n) = k + t(n-k)
    if k = n,

    t(n) = n + t(0) , tc: O(n)
 */
public class SumOfnNaturalNumbers {

    static int sum(int n) {

        if(n==0) { // base condition
            return 0;
        }

        return sum(n-1) + n; // recursive equation
    }


    public static void main(String[] args) {

        int n = 10;

        int r = n*(n+1)/2;
        int r1 = sum(n);

        System.out.println(r+" "+r1);
    }
}
