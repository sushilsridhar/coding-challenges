package strings;

/*
    You have given a string A having Uppercase English letters.

    You have to find that how many times subsequence "AG" is there in the given string.

     A = "ABCGAG" , answer 3 times

 */
public class OccurrenceOfSubsequence {
    public static void main(String[] args) {

        String A = "ABCGAG";
        System.out.println(bruteforce(A));

        System.out.println(bestSolution(A));

    }

    // time complexity: O(n)
    private static int bestSolution(String A) {
        int gCount=0, agCount=0;

        for(int i=A.length()-1; i>=0; i--) {
            if(A.charAt(i) == 'G') {
                gCount++;
            } else if(A.charAt(i) == 'A') {
                agCount = agCount + gCount;
            }
        }
        return agCount;
    }

    // time complexity: O(n^2)
    private static int bruteforce(String A) {

        int count = 0;
        for(int i=0; i<A.length(); i++) {
            if(A.charAt(i) == 'A') {
                for(int j=i+1; j<A.length(); j++) {
                    if(A.charAt(j) == 'G') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
