package queues;

import java.util.Arrays;

/*
    Given a string, find the first non repeating character
    s contains {a..z}

    e c h e d f c -> answer h

    approach:
    1. maintain a freq array

    2. maintain a freq array which tracks never seen elements, already seen elements and tracks the index of the element

    0 1 2 3 4 5 6
    e c h e d f c

    freq
     a  b  c  d  e  f  g  h
     0  1  2  3  4  5  6  7
    -1 -1 -1 -1 -1 -1 -1 -1
    -1 -1 -2  4 -2  5 -1  2

    -1 -> never seen
    -2 -> already seen (repeating)
    index -> occurs only once, the min index is the answer

    tc: O(n+k)
    sc: O(k), where k is the alphabet set, in this question it is a-z, but it may includes special char, french char etc for other cases
 */
public class FirstNonRepeatingChar {

    public static void main(String[] args) {

        String a = "echedfc";
        char ans = findFirstNonRepeatingChar(a);
        System.out.println(ans);

        char ans1 = efficient(a);
        System.out.println(ans1);
    }

    // tc: O(n+k)
    // sc: O(k)
    private static char efficient(String a) {

        int[] freq = new int[26];

        Arrays.fill(freq, -1); // O(k)

        for(int i=0; i<a.length(); i++) { // O(n)
            int index = a.charAt(i)-'a';
            if(freq[index] == -1)  {
                freq[index] = i;
            } else if(freq[index] >= 0) {
                freq[index] = -2;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<freq.length; i++) { // O(k)
            if(freq[i] >=0 && freq[i] < min) {
                min = freq[i];
            }
        }

        return a.charAt(min); // O(1)
    }

    // tc: O(n+n)
    // sc: O(k)
    private static char findFirstNonRepeatingChar(String a) {

        char[] freq = new char[26];

        for(int i=0; i<a.length(); i++) {
            freq[a.charAt(i)-'a']++;
        }

        for(int i=0; i<a.length(); i++) {
            if(freq[a.charAt(i)-'a'] == 1) {
                return a.charAt(i);
            }
        }

        return '#';
    }
}
