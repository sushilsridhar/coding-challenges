package hashing;

import java.util.HashMap;
import java.util.Map;

/*
    Given a string A consisting of lowercase characters.
    Check if characters of the given string can be rearranged to form a palindrome.
    Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

    A = "abbaee"
    A = "abbancc" - can be palindrome,

    approach: one odd number of letter and remaining freq of letter should be even
 */
public class CheckPalindrome {

    public static void main(String[] args) {

        String A = "abbancc";

        System.out.println(usingHashMap(A));
        System.out.println(usingArray(A));
    }

    // tc: O(n+n), sc: O(1), map will contain only 26 characters at max
    public static int usingArray(String A) {
        int[] freqArray = new int[26];

        for(int i=0; i<A.length(); i++) {
            char ele = A.charAt(i);
            freqArray[ele-97]++; // 97 is the ascii value of 'a'
        }

        int countOfOddCharacters = 0;
        for(int ele: freqArray) {
            if(ele%2 != 0) {
                countOfOddCharacters++;
            }
            if(countOfOddCharacters > 1) {
                return 0;
            }
        }
        return 1;
    }

    // tc: O(n+n), sc: O(1), map will contain only 26 characters at max
    public static int usingHashMap(String A) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<A.length(); i++) {
            char ele = A.charAt(i);
            if(map.containsKey(ele)) {
                map.put(ele, map.get(ele)+1);
            } else {
                map.put(ele, 1);
            }
        }
        int countOfOddCharacters = 0;
        for(Map.Entry<Character,Integer> ele: map.entrySet()) {
            if(ele.getValue()%2 != 0) {
                countOfOddCharacters++;
            }
            if(countOfOddCharacters > 1) {
                return 0;
            }
        }

        return 1;
    }
}
