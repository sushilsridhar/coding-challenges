package arrays.prefixsum;

/*
    Given a string s which contains only lower case alphabets,
    how many pairs i,j such that i<i and s[i] = a and s[j] = g


    0 1 2 3 4 5
    a b c g a g

    count 3

    tc: O(n)
 */

public class CheckPairsAG {
    public static void main(String[] args) {

        String s = "abcgag";
        System.out.println(countPairsAG(s));
    }

    private static int countPairsAG(String s) {

        int countOfG = 0;
        int countOfPair = 0;

        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == 'g') {
                countOfG++;
            } else if(s.charAt(i) == 'a') {
                countOfPair = countOfPair + countOfG;
            }
        }
        return countOfPair;
    }
}
