package trees.adv1;

/*
    You are given the root node of a binary tree A. You have to find the max value of all node values of this tree.

     Values =  1
              / \
             8   3
            /
           2

    max is 8,

    tc: O(n)
    sc: O(h)
 */
public class NodesMax {

    private static int solve(TreeNode A) {

        if(A == null) {
            return 0;
        }

        int maxOfLeft = solve(A.left);
        int maxOfRight = solve(A.right);
        int ans = 0;

        ans = Math.max(maxOfLeft, maxOfRight);

        return Math.max(ans, A.data);
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

        TreeNode root = new TreeNode(1);

        TreeNode two = new TreeNode(8);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(2);

        root.left = two;
        root.right = three;

        two.left = five;

        return root;
    }
}
