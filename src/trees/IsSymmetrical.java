package trees;

/*
    Given two binary trees, check if they are symmetric to each other

            1                               1
       2         3                     3         2
    4     5         6               6         5      4


           1                               1
       2         3                     3         2
    4     5         9               6         5      4


    roots value will be same, left node becomes right node

    tc: O(n)
 */
public class IsSymmetrical {

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

        System.out.println(isSymmetrical(root1, root2));

        TreeNode[] rootExampleTwo = setup2();

        TreeNode rootEg1 = rootExampleTwo[0];
        TreeNode rootEg2 = rootExampleTwo[1];

        System.out.println(isSymmetrical(rootEg1, rootEg2));
    }

    private static boolean isSymmetrical(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null) {
            return true;
        } else if(root1 == null || root2 == null) {
            return false;
        }

        if(root1.data != root2.data) {
            return false;
        }

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }

    public static TreeNode[] setup() {
        TreeNode[] array = new TreeNode[2];

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

        TreeNode root2 = new TreeNode(1);

        TreeNode twoRoot2 = new TreeNode(2);
        TreeNode threeRoot2 = new TreeNode(3);
        TreeNode fourRoot2 = new TreeNode(4);
        TreeNode fiveRoot2 = new TreeNode(5);
        TreeNode sixRoot2 = new TreeNode(6);

        root2.left = threeRoot2;
        root2.right = twoRoot2;

        twoRoot2.left = fiveRoot2;
        twoRoot2.right = fourRoot2;

        threeRoot2.left = sixRoot2;

        array[0] = root;
        array[1] = root2;

        return array;
    }

    public static TreeNode[] setup2() {
        TreeNode[] array = new TreeNode[2];

        TreeNode root = new TreeNode(1);

        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode nine = new TreeNode(9);

        root.left = two;
        root.right = three;

        two.left = four;
        two.right = five;

        three.right = nine;

        TreeNode root2 = new TreeNode(1);

        TreeNode twoRoot2 = new TreeNode(2);
        TreeNode threeRoot2 = new TreeNode(3);
        TreeNode fourRoot2 = new TreeNode(4);
        TreeNode fiveRoot2 = new TreeNode(5);
        TreeNode sixRoot2 = new TreeNode(6);

        root2.left = threeRoot2;
        root2.right = twoRoot2;

        twoRoot2.left = fiveRoot2;
        twoRoot2.right = fourRoot2;

        threeRoot2.left = sixRoot2;

        array[0] = root;
        array[1] = root2;

        return array;
    }
}
