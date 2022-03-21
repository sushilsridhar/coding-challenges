package trees;

/*
    Search a key in the binary tree, return true, if found else false

     tree:
                    1
              2            5
         3       4                6
                             7         8
                                9


    approach:

    use preorder traversal, so that if root is the key, we can return immediately without searching left and right

    fail fast/ success fast, returning immediately

    tc: O(n)
 */
public class SearchKeyInBinaryTree {

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

        System.out.println(searchInBinaryTree(root, 7));
        System.out.println(searchInBinaryTree(root, 100));
    }

    private static boolean searchInBinaryTree(TreeNode root, int key) {

        if(root == null) {
            return false;
        }

        System.out.println(root.data); // for testing purpose

        if(root.data == key) {
            return true;
        }

        if(searchInBinaryTree(root.left, key)) {
            return true;
        }
        return searchInBinaryTree(root.right, key);

        // can be written as
        // return searchInBinaryTree(root.left, key) || searchInBinaryTree(root.right, key);
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
