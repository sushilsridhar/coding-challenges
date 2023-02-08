package arrays.numbers;

/*
Example Input:
    A = [1, 2, 3]

Example Output:
    1

Explanation:
    only 2 have a strictly smaller and strictly greater element, 1 and 3 respectively.
 */
public class StrictlySmallerGreater {

    public static void main(String[] args) {

        int A[] = { 5, 4, 8, 2, 3};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int max = 0, min = 1000001;
        for(int i : A){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int ans = 0;
        for(int i : A){
            if(i > min && i < max)
                ans++;
        }
        return ans;
    }
}
