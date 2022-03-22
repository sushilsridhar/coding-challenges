package trees;

/*
    Invert a binary tree

            1                               1
       2         3                     3         2
    4     5         6               6         5      4


           1                              1
       2       3                      3       2
    4                                            4


    roots value will be same, left node becomes right node

    tc: O(n)
 */
public class InvertABinaryTree {

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

        preorder(invertTree(root));

        System.out.println("");

        TreeNode rootExampleTwo = setup2();

        preorder(invertTree(rootExampleTwo));
    }

    // pre order traversal
    private static TreeNode invertTree(TreeNode root) {

      if(root == null) {
          return root;
      } else if(root.left == null && root.right == null) {
          return root;
      }

      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;

      invertTree(root.left);
      invertTree(root.right);

      return root;
    }

    // neat code, post order traversal
    private static TreeNode invertTreeTwo(TreeNode root) {

        if(root == null) {
            return null;
        }

        TreeNode rst = invertTree(root.left);
        TreeNode lst = invertTree(root.right);

        root.left = rst;
        root.right = lst;

        return root;
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
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        root.left = two;
        root.right = three;

        two.left = four;
        two.right = five;

        three.right = six;

        return root;
    }

    public static TreeNode setup2() {
        TreeNode root = new TreeNode(1);

        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        root.left = two;
        root.right = three;

        two.left = four;

        return root;
    }
}
