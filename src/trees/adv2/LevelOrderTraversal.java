package trees.adv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
    Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
            4
       5         2
    1         3     6

    4 5 2 1 3 6 - level order traversal

    tc: O(n)
    sc: O(n), at the last level, the last level contains rougly n/2 elements, so it is O(n)
 */
public class LevelOrderTraversal {

    private static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        TreeNode root = A;

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            ArrayList<Integer> levelOrderList = new ArrayList<>();
            int size = queue.size();

            while(size > 0) {
                TreeNode node = queue.poll();
                levelOrderList.add(node.data);

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                size--;
            }

            list.add(levelOrderList);
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = setup();

        ArrayList<ArrayList<Integer>> list = levelOrder(root);

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
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode setup() {

        TreeNode root = new TreeNode(4);

        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        root.left = five;
        root.right = two;

        two.left = three;
        two.right = six;

        return root;
    }
}
