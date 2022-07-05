package trees.adv1;

/*
    You are given the root node of a binary tree A. You have to find the number of nodes in this tree.

            4
       5         2
              3     6

    count is 5

    tc: O(n)
    sc: O(h), if skewed tree, it is O(n)
 */
public class CountTheNodes {

    private static int solve(TreeNode A) {

        if(A == null) {
            return 0;
        }

        return solve(A.left) + solve(A.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = setup();

        System.out.println(solve(root));
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
