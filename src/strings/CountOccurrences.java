package strings;

/*
    Find number of occurrences of bob in the string A consisting of lowercase english alphabets.

    "abobc" - 1
    "bobob" - 2
 */
public class CountOccurrences {

    public static void main(String []args) {

        String str = "bobob";

        System.out.println(solve(str));
    }

    public static int solve(String A) {
        int count = 0;
        for(int i=1; i<A.length()-1; i++) {
            if(A.charAt(i) == 'o' && A.charAt(i-1) == 'b' && A.charAt(i+1) == 'b') {
                count++;
            }
        }
        return count;
    }
}
