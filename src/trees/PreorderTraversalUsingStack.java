package trees;

import java.util.ArrayList;
import java.util.Stack;

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
public class PreorderTraversalUsingStack {

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

        ArrayList<Integer> r = preorderTraversal(root);

        for(int i: r) {
            System.out.println(i);
        }
    }

    private static ArrayList<Integer> preorderTraversal(TreeNode A) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);

        ArrayList<Integer> r = new ArrayList<>();

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            if (node != null) {
                r.add(node.data);

                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }

        return r;
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
