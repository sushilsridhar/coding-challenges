package graphs;

import java.util.*;

/*
    from a given node, find the shortest distance to all other nodes

    undirected graph,
    n = 4, number of vertices or nodes,

    1 - 2
     \ |
      3 - 4

    adjacency list
    1 | 2 - 3
    2 | 1 - 3
    3 | 1 - 2 - 4

    output:

    1 0
    2 1
    3 1
    4 2

    approach:
    build adjacency list
    use a queue to maintain the level of elements, so that same level elements are processed first
    visitor array to mark already visited Vertex
    distance array to calculate the distance of each vertex from 1

    tc: O() TODO
    sc: O()
 */
public class BreadthFirstSearch {

    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Arrays.asList(1,2)));
        graph.add(new ArrayList<>(Arrays.asList(1,3)));
        graph.add(new ArrayList<>(Arrays.asList(2,1)));
        graph.add(new ArrayList<>(Arrays.asList(2,3)));
        graph.add(new ArrayList<>(Arrays.asList(3,1)));
        graph.add(new ArrayList<>(Arrays.asList(3,2)));
        graph.add(new ArrayList<>(Arrays.asList(3,4)));

        int[] r = bfs(n, graph);

        for(int i=1; i<r.length; i++) {
            System.out.println(i + " " + r[i]);
        }
    }

    private static int[] bfs(int n, ArrayList<ArrayList<Integer>> graph) {

        // build adjacency list
        HashMap<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();

        for(ArrayList<Integer> innerList: graph) {
            int vertex = innerList.get(0);
            int value = innerList.get(1);

            if(adjacencyList.containsKey(vertex)) {
                ArrayList<Integer> edgesList = adjacencyList.get(vertex);
                edgesList.add(value);
            } else {
                ArrayList<Integer> edgesList = new ArrayList<>();
                edgesList.add(value);
                adjacencyList.put(vertex, edgesList);
            }
        }

        int[] visitorArray = new int[n+1];
        int[] distanceArray = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visitorArray[1] = 1;
        distanceArray[1] = 0;

        while(!queue.isEmpty()) {
            int vertex = queue.poll();

            if(adjacencyList.containsKey(vertex)) {

                ArrayList<Integer> edgesList = adjacencyList.get(vertex);
                for(int edge: edgesList) {
                    if(visitorArray[edge] != 1) {

                        queue.add(edge);
                        visitorArray[edge] = 1;
                        distanceArray[edge] = distanceArray[vertex] + 1;
                    }
                }
            }
        }

        return distanceArray;
    }
}
