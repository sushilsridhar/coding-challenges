package strings;

/*
    Given a string, calculate the length of the largest palindrome substring

    abaeaby
    baeab -> length 5 -> answer

    0 1 2 3 4 5 6 7 8 9 10 11 12 13  14
    x b d y z z y d b d  y  z  y  d  x

    answer - b d y z z y d b , length 8

    consider for center at 8, odd answer, i and j are initialized to same, i=4, j=12, first mismatch, 12-4-1 = 7, (a,b) -> a-b-1, formula for count excluding a and b
    consider for center at 4, even answer, i=4, j=i+1 initialized, i=0, j=9, first mismatch, 9-0-1 = 8,

    steps
    1. start at a index(index 8 in example), check if left side and right side are same, if same, check next left and right
       i and j are same, starting at index 8, this is odd length substring answer
    2. incase of even length substring answer, i starts at 8 for example, j will start at i+1, 9

    note:
    odd length palindrome, there is only one center, iterate and consider each value as center, then compare the left and right and so on.
    even length palindrome, there are two centers, iterate and consider each value as center one and its next value as center two, keep comparing them

 */
public class LargestPalindromeSubstring {

    public static void main(String []args) {

        String str = "xbdyzzydbdyzydx";

        System.out.println(bruteForce(str));
        System.out.println(solution(str));


        System.out.println("hello".substring(1, 5));
        System.out.println("hello".substring(-1+1, 5));

        /*
            prints ello, substring method is exclusive of start index and inclusive of end index
            also for substring method, index starts from 1 not 0
         */
    }

    // Time complexity: O(n2), inner loop called for each iteration
    private static int solution(String str) {
        int length = 0;
        int maxLen = 0;

        for(int i=0; i<str.length(); i++) {

            // incase of odd length substring answer, i and j are same
            int centerOne = i;
            int centerTwo = i;
            length = getLengthOfPalindrome(str, centerOne, centerTwo);
            maxLen = Math.max(maxLen, length);

            // incase of even length substring answer, j is i+1
            centerTwo = i+1;
            length = getLengthOfPalindrome(str, centerOne, centerTwo);
            maxLen = Math.max(maxLen, length);

        }
        return maxLen;
    }

    private static int getLengthOfPalindrome(String str, int centerOne, int centerTwo) {

        int n = str.length()-1;
        int i=centerOne, j=centerTwo;

        while(i>=0 && j<=n && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }

        return j-i-1; // (a,b) -> b-a-1, count excluding a and b
    }


    // tc: O(n^3)
    private static String bruteForce(String A) {

        int maxLen = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        int n = A.length();

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                String a = A.substring(i, j+1);

                if(checkPalindrome(a)) {
                    int len = j-i+1;
                    if(len > maxLen) {
                        maxLen = len;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }

        return A.substring(startIndex, endIndex+1);
    }

    private static boolean checkPalindrome(String a) {

        StringBuilder builder = new StringBuilder();

        for(int i=a.length()-1; i>=0; i--) {
            builder.append(a.charAt(i));
        }

        if((builder.toString()).equals(a)) {
            return true;
        }

        return false;
    }
}
