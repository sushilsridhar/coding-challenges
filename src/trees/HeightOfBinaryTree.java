package trees;

/*
    Given a binary tree, find its height

    height is length of the largest path from root to leaf node

    tree:
                    1
              2            5
         3       4                6
                             7         8
                                9

    output: 5

    example:         1
                2         3
            4

     h1 - height of left sub tree
     h2 - height of right sub tree

     r = max(h1, h2) + 1, plus one is for root element
 */
public class HeightOfBinaryTree {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = setup();

        System.out.println(height(root));
    }

    private static int height(TreeNode root) {
            if(root == null) {
                return 0;
            }

            int left = height(root.left);
            int right = height(root.right);
            return Math.max(left, right) + 1;
    }

    public static TreeNode setup() {
        TreeNode root = new TreeNode(1);

        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);

        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        TreeNode six = new TreeNode(6);

        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        TreeNode nine = new TreeNode(9);


        root.left = two;
        root.right = five;

        two.left = three;
        two.right = four;

        five.right = six;

        six.left = seven;
        six.right = eight;

        seven.right = nine;

        return root;
    }
}
