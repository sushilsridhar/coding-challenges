package strings;

/*
    You are given a string A of size N consisting of lowercase alphabets.

    You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

    Find the minimum number of distinct characters in the resulting string.

    A = "abcabbccd"
    B = 3

    We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
    So the minimum number of distinct character will be 2.

    tc: O(n + B)
 */
public class ChangeCharacter {

    public static void main(String[] args) {

        System.out.println(solve("abcabbccd", 3));
    }

    private static int solve(String A, int B) {

        int[] freq = new int[26];

        for(int i=0; i<A.length(); i++) {
            int index = A.charAt(i) - 'a';
            if(freq[index] > 0) {
                freq[index] = freq[index] + 1;
            } else {
                freq[index] = 1;
            }
        }

        while(B > 0) {

            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int i=0; i<26; i++) {
                if(freq[i] > 0 && freq[i] < min) {
                    min = freq[i];
                    minIndex = i;
                }
            }

            int decrementBby = freq[minIndex];
            freq[minIndex] = freq[minIndex] - B;
            B =  B - decrementBby;
        }

        int count = 0;
        for(int i=0; i<26; i++) {
            if(freq[i] > 0) {
                count++;
            }
        }

        return count;
    }
}
