package trees;

/*
    Search a key in the balanced binary tree, return true, if found else false

     tree:
                    5
              3          6
         2       4           7


    approach:

    use preorder traversal, so that if root is the key, we can return immediately without searching left and right

    fail fast/ success fast, returning immediately

    tc: O(logn)
 */
public class SearchKeyInBalancedBT {

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

        System.out.println(searchInBalancedBinaryTree(root, 4));
        System.out.println(searchInBalancedBinaryTree(root, 100));
    }

    private static boolean searchInBalancedBinaryTree(TreeNode root, int key) {

        if(root == null) {
            return false;
        }
        boolean ans = false;
        if(root.data == key) {
            return true;
        } else if(key > root.data) {
            ans = searchInBalancedBinaryTree(root.right, key);
        } else if(key < root.data) {
            ans = searchInBalancedBinaryTree(root.left, key);
        }

        return ans;
    }

    public static TreeNode setup() {
        TreeNode root = new TreeNode(5);

        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);

        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        TreeNode six = new TreeNode(6);

        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        TreeNode nine = new TreeNode(9);


        root.left = three;
        root.right = six;

        three.left = two;
        three.right = four;

        five.right = six;

        six.right = seven;

        return root;
    }

}
