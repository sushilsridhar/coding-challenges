package trees;

/*
    Given two binary trees, check if they are identical or not

    root 1                    root 2
          3                      3
      2       5              2       5
    1           8          1           8

   root1                     root2
         3                     3
      1     2               2

    approach:

    base condition, if both roots are null, they are equal return true

    tc: O(n)
 */
public class IsTwoBSTIdentical {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        TreeNode[] root = setup();

        TreeNode root1 = root[0];
        TreeNode root2 = root[1];

        System.out.println(isIdentical(root1, root2));

        root = setupTwo();

        root1 = root[0];
        root2 = root[1];

        System.out.println(isIdentical(root1, root2));
    }

    private static boolean isIdentical(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null) {
            return false;
        }

        if(root1.data != root2.data) {
            return false;
        }

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    public static TreeNode[] setup() {
        TreeNode[] array = new TreeNode[2];

        TreeNode root1 = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);

        TreeNode one = new TreeNode(1);
        TreeNode eight = new TreeNode(8);

        root1.left = two;
        root1.right = five;
        two.left = one;
        five.right = eight;

        TreeNode root2 = new TreeNode(3);

        root2.left = two;
        root2.right = five;
        two.left = one;
        five.right = eight;

        array[0] = root1;
        array[1] = root2;

        return array;
    }

    public static TreeNode[] setupTwo() {
        TreeNode[] array = new TreeNode[2];

        TreeNode root1 = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);

        root1.left = one;
        root1.right = two;

        TreeNode root2 = new TreeNode(3);

        root2.left = two;

        array[0] = root1;
        array[1] = root2;

        return array;
    }
}
