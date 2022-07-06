package trees.adv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
    Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
          6
        /   \
       3     7
      / \     \
     2   5     9

    2
    3
    6 5
    7
    9

    tc: O()
    sc: O()
 */
public class VerticalOrderTraversal {

    private static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        TreeNode root = A;

        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        int startDistance = Integer.MAX_VALUE;
        int endDistance = Integer.MIN_VALUE;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size > 0) {
                Pair pair = queue.poll();

                TreeNode node = pair.getNode();
                int distanceFromRoot = pair.getDistanceFromRoot();

                startDistance = Math.min(startDistance, distanceFromRoot);
                endDistance = Math.max(endDistance, distanceFromRoot);

                if(map.containsKey(distanceFromRoot)) {
                    ArrayList<Integer> list = map.get(distanceFromRoot);
                    list.add(node.val);

                    map.put(distanceFromRoot, list);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(node.val);
                    map.put(distanceFromRoot, list);
                }


                if(node.left != null)
                    queue.add(new Pair(node.left, distanceFromRoot-1));
                if(node.right != null)
                    queue.add(new Pair(node.right, distanceFromRoot+1));

                size--;
            }
        }

        for(int i=startDistance; i<=endDistance; i++) {
            ansList.add(map.get(i));
        }

        return ansList;
    }

    static class Pair {
        TreeNode node;
        int distanceFromRoot;

        Pair(TreeNode node, int distanceFromRoot) {
            this.node = node;
            this.distanceFromRoot = distanceFromRoot;
        }

        public TreeNode getNode() {
            return node;
        }

        public int getDistanceFromRoot() {
            return distanceFromRoot;
        }
    }

    public static void main(String[] args) {
        TreeNode root = setup();

        ArrayList<ArrayList<Integer>> list = verticalOrderTraversal(root);

        for(ArrayList<Integer> l: list) {
            for (int i: l) {
                System.out.print(i+" ");
            }
            System.out.println("");
        }

    }

    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode setup() {

        TreeNode nine = new TreeNode(9);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        six.left = three;
        six.right = seven;

        three.left = two;
        three.right = five;

        seven.right = nine;

        return six;
    }

}
