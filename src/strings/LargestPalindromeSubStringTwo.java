package strings;

/*
    Given a string A of size N, find and return the longest palindromic substring in A.

    Substring of string A is A[i...j] where 0 <= i <= j < len(A)

    Palindrome string:
    A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

    Incase of conflict, return the substring which occurs first ( with the least starting index).

    tc: O(n^2)
 */
public class LargestPalindromeSubStringTwo {

    public static void main(String []args) {

        String str = "xbdyzzydbdyzydx";

        String a = "abb";
        String b = "abaeaby";


        System.out.println(longestPalindrome(str));
        System.out.println(longestPalindrome(a));
        System.out.println(longestPalindrome(b));

        System.out.println("-------------------");
                        // 0 1 2 3 4
                        // h e l l o
        System.out.println("hello".substring(1, 5));
        System.out.println("hello".substring(-1+1, 5));
        System.out.println("hello".substring(0, 1));

        /*
            Substring method internal working

            prints ello,
            0-1 -> prints h

            substring method is exclusive of start index and inclusive of end index
            also for substring method, index starts from 1 not 0, endIndex of 5 in substring means actual index of 4 in string

            in other words,

                        // 0 1 2 3 4 - string index
                        // 1 2 3 4 5 - substring method index
                        // h e l l o
            i-j (0-1) means, print from i+1 to j with starting index as 1

            0-1 --> 1-1 -> since startindex is from 1 for substring, h is printed
            0-5 --> 1-5 -> hello is printed,
         */
    }

    private static String longestPalindrome(String A) {

        int maxLen = Integer.MIN_VALUE;
        String longestPalindrome = "";

        for(int i=0; i<A.length(); i++) {

            int centerOne = i;
            int centerTwo = i;

            String palindrome = getMaxPalindromeForC1AndC2(A, centerOne, centerTwo);

            if(palindrome.length() > maxLen) {
                longestPalindrome = palindrome;
                maxLen = palindrome.length();
            }

            centerTwo = i+1;
            palindrome = getMaxPalindromeForC1AndC2(A, centerOne, centerTwo);

            if(palindrome.length() > maxLen) {
                longestPalindrome = palindrome;
                maxLen = palindrome.length();
            }
        }

        return longestPalindrome;
    }

    private static String getMaxPalindromeForC1AndC2(String a, int c1, int c2) {
        int i = c1;
        int j = c2;
        int n = a.length();

        while(i>=0 && j<n && a.charAt(i) == a.charAt(j)) {
            i--;
            j++;
        }

        return a.substring(i+1,j);
    }
}
