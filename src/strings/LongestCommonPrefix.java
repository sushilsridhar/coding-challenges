package strings;

/*
    Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.

    The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

    Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".

    tc: O(l * n), l is the number of strings present in array, n is the length of the smallest string
 */
public class LongestCommonPrefix {

    public static void main(String []args) {

        String[] A = {"abab", "ab", "abcd"};
        String[] B = {"abcdefgh", "aefghijk", "abcefgh"};

        System.out.println(longestCommonPrefix(A));
        System.out.println(longestCommonPrefix(B));

        System.out.println(longestCommonPrefixRecursiveCode(A));
        System.out.println(longestCommonPrefixRecursiveCode(B));

    }

    // tc: O(l * n), sc: O(1)
    private static String longestCommonPrefix(String[] A) {

        String minLenString = "";
        int min = Integer.MAX_VALUE;

        for(int i=0; i<A.length; i++) {
            if(A[i].length() < min) {
                min = A[i].length();
                minLenString = A[i];
            }
        }

        int k = 0;
        while(k < minLenString.length()) {

            char charToBePresent = minLenString.charAt(k);

            for(int j=0; j<A.length; j++) {

                if(A[j].charAt(k) != charToBePresent) {
                    if(k == 0) {
                        return "";
                    } else {
                        return  minLenString.substring(0, k);
                    }
                }
            }
            k++;
        }

        return minLenString;
    }

    // tc: O(l * n), sc: O(n)
    private static String longestCommonPrefixRecursiveCode(String[] A) {

        return recursiveCall(A, A[0], 1);
    }

    private static String recursiveCall(String[] A, String commonPrefix, int index) {

        if(index == A.length) {
            return commonPrefix;
        }

        String largestCommonPrefix = getLargestCommonPrefix(commonPrefix, A[index]);
        return recursiveCall(A, largestCommonPrefix, ++index);
    }

    private static String getLargestCommonPrefix(String str1, String str2) {

        int minLen = 0;
        String minString = "";
        if(str1.length() < str2.length()) {
            minLen = str1.length();
            minString = str1;
        } else {
            minLen = str2.length();
            minString = str2;
        }

        int k = 0;
        while(k < minLen) {

            if(str1.charAt(k) != str2.charAt(k)){
                return str1.substring(0,k);
            }
            k++;
        }

        return minString;
    }
}
