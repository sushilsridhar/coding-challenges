package trees;

/*
    Given the root of a tree A with each node having a certain value, find the count of nodes with more value than all its ancestor.


            4
       5         2
              3     6

    4,5,6 -> count is 3

    approach:
    compare root with left and right child
    if 2 is less than 4, then compare 4 and 6 instead of 2 and 6

    tc: O(n), n is the total number of nodes
 */
public class CountingTheGreaterNodes {

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

        System.out.println(countGreaterNodes(root, 0));
    }

    private static int countGreaterNodes(TreeNode A, int greaterRoot) {

        if(A == null) {
            return 0;
        }

        int count = 0;
        if(A.data > greaterRoot) {
            count++;
            count = count + countGreaterNodes(A.left, A.data) + countGreaterNodes(A.right, A.data);
        } else {
            count = count + countGreaterNodes(A.left, greaterRoot) + countGreaterNodes(A.right, greaterRoot);
        }

        return count;
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
