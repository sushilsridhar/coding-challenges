package trees.adv2;

import java.util.*;

/*
    TODO
 */
public class TopViewOfBinaryTree {

    public ArrayList<Integer> solve(TreeNode A) {

        TreeNode root = A;

        ArrayList<Integer> ansList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size > 0) {
                Pair pair = queue.poll();

                TreeNode node = pair.getNode();
                int distanceFromRoot = pair.getDistanceFromRoot();

                if(!set.contains(distanceFromRoot)) {
                    ansList.add(node.val);
                    set.add(distanceFromRoot);
                }

                if(node.left != null)
                    queue.add(new Pair(node.left, distanceFromRoot-1));
                if(node.right != null)
                    queue.add(new Pair(node.right, distanceFromRoot+1));

                size--;
            }
        }

        return ansList;
    }

    class Pair {
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

        TreeNode root = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        root.left = five;
        root.right = two;

        five.left = one;

        two.left = three;
        two.right = six;

        return root;
    }
}
