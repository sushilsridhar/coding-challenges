package backtracking;

import java.util.ArrayList;
import java.util.HashSet;

/*
    TODO
 */
public class NQueens {

    public ArrayList<ArrayList<String>> solveNQueens(int A) {

        ArrayList<ArrayList<String>> ansList = new ArrayList<>();

        if(A == 1) {
            ArrayList<String> distinctSolution = new ArrayList<>();
            distinctSolution.add("Q");
            ansList.add(distinctSolution);
            return ansList;
        }

        if(A < 4) {
            return ansList;
        }

        int[] container = new int[A];
        ArrayList<ArrayList<Integer>> tempAnsList = new ArrayList<>();


        HashSet<Integer> columnSet = new HashSet<>();
        HashSet<Integer> diagonalUpperLeftSet = new HashSet<>();
        HashSet<Integer> diagonalUpperRightSet = new HashSet<>();

        backtracking(tempAnsList, container, A, 0, columnSet, diagonalUpperLeftSet, diagonalUpperRightSet);


        for(ArrayList<Integer> distinctSolution: tempAnsList) {
            ArrayList<String> ans = new ArrayList<>();
            for(int queenIndex: distinctSolution) {
                StringBuilder builder = new StringBuilder();

                for(int j=0; j<A; j++) {
                    if(j == queenIndex) {
                        builder.append("Q");
                    } else {
                        builder.append(".");
                    }
                }
                ans.add(builder.toString());
            }
            ansList.add(ans);
        }

        return ansList;
    }

    private void backtracking(ArrayList<ArrayList<Integer>> tempAnsList, int[] container, int n, int rowIndex,
                              HashSet<Integer> columnSet, HashSet<Integer> diagonalUpperLeftSet, HashSet<Integer> diagonalUpperRightSet) {

        if(rowIndex == n) {
            ArrayList<Integer> distinctSolution = new ArrayList<>();

            for(int i=0; i<container.length; i++) {
                distinctSolution.add(container[i]);
            }
            tempAnsList.add(distinctSolution);
        }

        for(int j=0; j<n; j++) {
            if(columnSet.contains(j) || diagonalUpperLeftSet.contains(rowIndex - j) ||
                    diagonalUpperRightSet.contains(rowIndex + j)) {
                continue;
            }

            columnSet.add(j);
            diagonalUpperLeftSet.add(rowIndex - j);
            diagonalUpperRightSet.add(rowIndex + j);
            container[rowIndex] = j;

            backtracking(tempAnsList, container, n, rowIndex+1, columnSet, diagonalUpperLeftSet, diagonalUpperRightSet);

            container[rowIndex] = -1;
            diagonalUpperRightSet.remove(rowIndex + j);
            diagonalUpperLeftSet.remove(rowIndex - j);
            columnSet.remove(j);
        }
    }
}
