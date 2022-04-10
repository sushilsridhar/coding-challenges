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

    output: 3 4 2 9 7 8 6 5 1
 */
public class UsingStackPostorderTraversal {

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

        int[] r = postorderTraversal(root);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }

    private static int[] postorderTraversal(TreeNode A) {

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        stack.push(A);

        while(!stack.empty()) {

            TreeNode node = stack.pop();

            TreeNode rightNode = node.right;
            TreeNode leftNode = node.left;

            if(rightNode != null || leftNode != null) {
                node.left = null;
                node.right = null;
                stack.push(node);
            }

            if(rightNode != null) {
                stack.push(rightNode);
            }

            if(leftNode != null) {
                stack.push(leftNode);
            }

            if(leftNode == null && rightNode == null) {
                list.add(node.data);
            }
        }

        return list.stream().mapToInt(ele->ele).toArray();
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
