package trees;

/*
            1
       2         3
    4     5         6

    5 --> 1 2 5
    6 --> 1 3 6

    tc: O(n)
    sc: O(n)
 */
public class PathToGivenNode {

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

        int[] r = traceRoot(root, 5, 0);

        for(int i: r) {
            System.out.print(i+" ");
        }

        System.out.println("");

        int[] r1 = traceRoot(root, 6, 0);

        for(int i: r1) {
            System.out.print(i+" ");
        }
    }

    private static int[] traceRoot(TreeNode A, int B, int indexOfResultArray) {

        if(A == null) {
            return new int[]{};
        }

        if(A.data == B) {
            int[] r = new int[indexOfResultArray+1];
            r[indexOfResultArray] = A.data;
            return r;
        }

        int[] left = traceRoot(A.left, B, indexOfResultArray+1);
        int[] right = traceRoot(A.right, B, indexOfResultArray+1);

        if(left.length > 0) {
            left[indexOfResultArray] = A.data;
            return left;
        } else if(right.length > 0) {
            right[indexOfResultArray] = A.data;
            return right;
        }

        return new int[]{};
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
}
