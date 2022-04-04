package hashing;

import java.util.HashSet;

/*
    Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

    The Sudoku board could be partially filled, where empty cells are filled with the character '.'

    input
    ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]

    5 3 .   . 7 .  . . .
    6 . .   1 9 5  . . .

    approach:

    see there is repetition of numbers in every row
    see there is repetition of numbers in every column
    see there is repetition of numbers in every box ( 3 x 3 box), total 9 boxes

 */
public class ValidSuduko {

    public static void main(String[] args) {

        String[] A = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"} ;

        System.out.println(isValidSudoku(A));
    }

    private static int isValidSudoku(final String[] A) {

        for(int i=0; i<A.length; i++) {
            HashSet<Character> set = new HashSet<>();

            String row = A[i];

            for(int j=0; j<row.length(); j++) {
                char rowValue = row.charAt(j);

                if('.' != rowValue) {
                    if(set.contains(rowValue)) {
                        return 0;
                    }
                    set.add(rowValue);
                }
            }
        }


        for(int j=0; j<A[0].length(); j++) {
            HashSet<Character> set = new HashSet<>();

            for(int i=0; i<A.length; i++) {
                char columnValue = A[i].charAt(j);

                if('.' != columnValue) {
                    if(set.contains(columnValue)) {
                        return 0;
                    }
                    set.add(columnValue);
                }
            }
        }

        int totalBox = 1;
        int boxNumber = 1;
        int startingRow = 0;
        int startingColumn = 0;

        while(totalBox <= 9) {
            HashSet<Character> set = new HashSet<>();

            for(int i=startingRow; i<startingRow+3; i++) {
                String row =  A[i];

                for(int j=startingColumn; j<startingColumn+3; j++) {
                    char val = row.charAt(j);

                    if('.' != val) {
                        if(set.contains(val)) {
                            return 0;
                        }
                        set.add(val);
                    }
                }
            }
            boxNumber++;
            startingColumn = startingColumn + 3;

            if(boxNumber > 3) {
                boxNumber = 1;
                startingRow = startingRow + 3;
                startingColumn = 0;
            }

            totalBox++;
        }

        return 1;
    }

    // optimization for searching in every box
    /*
      for (int k = 0; k < 9; k++) {
        int x = k / 3;
        int y = k % 3;
        hashSet.clear();
        for (int i = 3 * x; i < 3 * x + 3; i++) {
            for (int j = y * 3; j < y * 3 + 3; j++) {
                char c = A.get(j).charAt(i);
                if (c == '.')
                    continue;
                if (hashSet.contains(c))
                    return 0;
                hashSet.add(c);
            }
        }

    }
     */
}
