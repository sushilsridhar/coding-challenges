package graphs;

import java.util.ArrayList;
import java.util.HashMap;

/*
    TODO
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        if(2 > list.size()) {
            list.add(2,2);
        }
        System.out.println(list.get(2));
    }
    public int solve(ArrayList<Integer> A, final int B, final int C) {

        if(B == C)
            return 1;

        HashMap<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();

        for(int i=1; i<A.size(); i++) {
            int vertex = A.get(i);

            if(adjacencyList.containsKey(vertex)) {
                ArrayList<Integer> list = adjacencyList.get(vertex);
                list.add(i+1);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i+1);
                adjacencyList.put(vertex, list);
            }
        }

        int n = A.size();
        int[] visitedArray = new int[n+1];
        int startTown = C;
        int destinationTown = B;

        return dfs(adjacencyList, visitedArray, startTown, destinationTown);
    }

    private int dfs(HashMap<Integer, ArrayList<Integer>> adjacencyList, int[] visitedArray, int startTown, int destinationTown) {

        visitedArray[startTown] = 1;

        if(adjacencyList.containsKey(startTown)) {
            ArrayList<Integer> edges = adjacencyList.get(startTown);

            for(int neighbourVertex: edges) {
                if(visitedArray[neighbourVertex] != 1) {

                    if(neighbourVertex == destinationTown)
                        return 1;

                    int r = dfs(adjacencyList, visitedArray, neighbourVertex, destinationTown);

                    if(r == 1)
                        return 1;
                }
            }
        }

        return 0;
    }
}
