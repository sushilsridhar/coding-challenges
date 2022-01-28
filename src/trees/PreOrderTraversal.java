package trees;

/*
    Traverse the tree in pre order

    tree:
                    1
              2            5
         3       4                6
                             7         8
                                9

    output: 1 2 3 4 5 6 7 9 8
 */
public class PreOrderTraversal {

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

        preorder(root);
    }

    private static void preorder(TreeNode root) {

        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
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
