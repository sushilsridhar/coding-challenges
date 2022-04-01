package trees;

import java.util.ArrayList;
import java.util.Stack;

/*
    Traverse the tree in in order

    tree:
                    1
              2            5
         3       4                6
                             7         8
                                9

    output: 3 2 4 1 5 7 9 6 8
 */
public class UsingStackInorderTraversal {

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

        ArrayList<Integer> r = inorderTraversal(root);

        for(int i: r) {
            System.out.print(i+" ");
        }
    }

    private static ArrayList<Integer> inorderTraversal(TreeNode A) {

        Stack<TreeNode> stack = new Stack();
        ArrayList<Integer> r = new ArrayList<>();

        while(A!= null || !stack.empty()) {

            if(A != null) {
                stack.push(A);
                A = A.left;
            } else {
                TreeNode node = stack.pop();
                r.add(node.data);
                A = node.right;
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
