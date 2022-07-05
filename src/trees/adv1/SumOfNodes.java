package trees.adv1;

/*
    You are given the root node of a binary tree A. You have to find the sum of node values of this tree.

    tc: O(n)
    sc: O(h), height of binary tree
 */
public class SumOfNodes {

    public static int sum(TreeNode A) {

        if(A == null) {
            return 0;
        }

        return sum(A.left) + sum(A.right) + A.data;
    }

    public static void main(String[] args) {
        TreeNode root = setup();

        System.out.println(sum(root));
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
