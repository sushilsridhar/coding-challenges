package arrays.subarrays;

import java.util.HashMap;

/*
    Technique: Dynamic sliding window

    Given a string, return the length of the longest substring without repeating characters, all are lowercase charaters

    str = "abcdbcae"
    ans = dbcae (5)

    str = "pwwkew"
    ans = 3 (wke)

    a b c d b c a e
    0 1 2 3 4 5 6 7
                map
    s=0 e=0   , a 0 , maxlen 1
    s=0 e=1   , b 1 , maxlen 2,
    s=0 e=2   , c 2 , maxlen 3
    s=0 e=3   , d 3 , maxlen 4
    s=0 e=4   , b 4 , maxlen 4, b updated, b is inside subarray

    s=2 e=5   , c 5 , maxlen 4, c updated, c is inside subarray
    s=3 e=6   , a 6 , maxlen 4, a updated, a is outside subarray
    s=3 e=7   , e 7 , maxlen 5

    inside or outside calculation --> hashMap.get(currentChar) < start
 */
public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {

       String str = "abcdbcae";

       System.out.println(solution(str));
    }

    public static int solution(String str) {

        HashMap<Character,Integer> hashMap = new HashMap<>();

        int n = str.length();
        int start=0, end=0;
        int maxLen = 0;

        while(end < n) {
            char currentChar = str.charAt(end);
            if(!hashMap.containsKey(currentChar) || hashMap.get(currentChar) < start) {
                hashMap.put(currentChar, end);
                maxLen = Math.max(end-start+1, maxLen);
            } else {
                int previousOccurrenceOfCurrentElement = hashMap.get(currentChar);
                start = previousOccurrenceOfCurrentElement + 1;
                hashMap.put(currentChar, end);
                maxLen = Math.max(end-start+1, maxLen);
            }

            end++;
        }
        return maxLen;
    }
}
