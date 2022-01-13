package strings;

/*
    Technique:
    Count Sort, counting the frequency of elements and sorting

    Given a string and string contains
    -- only lower case characters --,
    Sort the string

    "dabaedb"
    "aabbdde"

    ASCII
    0  'a' - 97
    1  'b' - 98
    2  'c' - 99
    25 'z' - 122,

    mapping a to index 0, subtract by 'a'(97), gives the index 0
    'a' - 97 = index
    'a' = index + 97

    1) count the frequency of every character and store it
    2) Use the frequency to sort
 */
public class SortString {
    public static void main(String []args) {

        String str = "dabaedb"; // ans - aabbdde

        System.out.println(countSort(str));
    }

    // Time complexity - O(n)
    private static String countSort(String str) {
        StringBuilder builder = new StringBuilder();
        int[] frequencyArray = new int[26];

        // O(n)
        for(int i=0; i<str.length(); i++) {
            int index = str.charAt(i) - 'a';
            frequencyArray[index] = frequencyArray[index] + 1;
        }

        // O(n) times, adding all frequency would result in length of the string, n is length of the string
        for(int i=0; i<26; i++) {
            int freq = frequencyArray[i];
            for(int j=0; j<freq; j++) {
                char ans = (char) (i + 97);
                builder.append(ans);
            }
        }

        return builder.toString();
    }
}
