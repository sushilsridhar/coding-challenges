package trees.adv1;

/*
    You are given the root node of a binary tree A. Each node has a value val and depth depth.

    Initially depth of each node is set to -1. You have to fill the depth of each node with its correct value.
    Depth of a node T is the number of nodes along the longest path from the root node down to node T. Also, depth of root node is always equal to 1.

     Values =  1        Depths =  1
              / \                / \
             4   3              2   2
            /                  /
           2                  3

            4
       5         2
              3     6

     tc: O(n)
     sc: O(h)
 */
public class DepthOfEachNode {

    private static void solve(TreeNode root) {
        setDepth(root, 1);
    }
    private static void setDepth(TreeNode A, int depth) {

        if(A == null) {
            return;
        }

        A.depth = depth;

        setDepth(A.left, depth+1);
        setDepth(A.right, depth+1);
    }

    public static void main(String[] args) {
        TreeNode root = setup();

        solve(root);
        preorder(root);
    }

    /* ----------------------------------------------------------------------------- */
    /* ------------------------------------ HELPER --------------------------------- */
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        int depth;

        TreeNode(int data) {
            this.data = data;
            this.depth = -1;
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

    private static void preorder(TreeNode root) {

        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        System.out.print(root.depth+" ,");
        preorder(root.left);
        preorder(root.right);
    }
}
