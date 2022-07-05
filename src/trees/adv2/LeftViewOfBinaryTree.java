package trees.adv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
    Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
    Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
    NOTE: The value comes first in the array which have lower level.

            4
       5         2
              3     6

    4 5 3 - left view

    tc: O(n)
    sc: O(n), at the last level, the last level contains rougly n/2 elements, so it is O(n)
 */
public class LeftViewOfBinaryTree {

    private static ArrayList<Integer> leftView(TreeNode A) {

        TreeNode root = A;

        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int count = 0;
            while(count < size) {
                TreeNode node = queue.poll();

                if(count == 0) {
                    list.add(node.val);
                }

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);

                count++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = setup();

        ArrayList<Integer> list = leftView(root);
        for (int i: list) {
            System.out.print(i+" ");
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

        TreeNode root = new TreeNode(4);
        TreeNode one = new TreeNode(1);
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
