package trees;

/*
    Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

            1
       2          2
    3     4    4     3


            1
      2           2
  3      4     4     3
       5     5


    consider 2(left) and 2(right) as two separate node and,
    check if a.left == b.right and a.right == b.left

    tc: O(n)
 */
public class IsCenterSymmetrical {

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

        System.out.println(isSymmetric(root));

        TreeNode root1 = setup2();

        System.out.println(isSymmetric(root1));
    }

    public static int isSymmetric(TreeNode A) {

        if(A == null) {
            return 1;
        }

        return recursion(A.left, A.right);
    }

    private static int recursion(TreeNode node1, TreeNode node2) {

        if(node1 == null && node2 == null) {
            return 1;
        }

        if(node1 == null || node2 == null) {
            return 0;
        }

        if(node1.data != node2.data) {
            return 0;
        }

        return recursion(node1.left, node2.right) & recursion(node1.right, node2.left);
    }

    public static TreeNode setup() {

        TreeNode root = new TreeNode(1);

        TreeNode two = new TreeNode(2);
        TreeNode two2 = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode three3 = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode four2 = new TreeNode(4);

        root.left = two;
        root.right = two2;

        two.left = three;
        two2.right = three3;

        two.right = four;
        two2.left = four2;

        return root;
    }

    public static TreeNode setup2() {

        TreeNode root = new TreeNode(1);

        TreeNode two = new TreeNode(2);
        TreeNode two2 = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode three3 = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode four2 = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode five2 = new TreeNode(5);


        root.left = two;
        root.right = two2;

        two.left = three;
        two2.right = three3;

        two.right = four;
        two2.left = four2;

        four.left = five;
        four2.left = five2;

        return root;
    }
}
