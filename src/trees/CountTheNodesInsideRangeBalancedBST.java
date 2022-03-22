package trees;

/*
    Given a range [s, e] and a BST, count the nodes which have a value in range [s,e]
    s <= node.val <= e

                    20
            10              30
        5       18                50
                             40        70

    [17, 45] -> ans = 4

    approach:

    ----------------------------
           s          e
    root       root        root

    root may be in one of the three places

     s>= root <=e --> count both left and right + 1(for root)
    root < s --> ignore left and move to right
    root > e --> ignore right and move to left

    tc: O(n)
 */
public class CountTheNodesInsideRangeBalancedBST {

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

        System.out.println(count(root, 17, 45));
        System.out.println(count(root, 10, 50));
        System.out.println(count(root, 1, 4));


        System.out.println(optimizedCount(root, 17, 45));
        System.out.println(optimizedCount(root, 10, 50));
        System.out.println(optimizedCount(root, 1, 4));

    }

    private static int optimizedCount(TreeNode root, int s, int e) {

        if(root == null) {
            return 0;
        }

        // this condition can't be applied if there are duplicate elements,
        // this condition is not mandatory for code to work
        /*if(root.data == s && root.data == e) {
            return 1;
        }*/

        int ans = 0;
        if((root.data >= s) && (root.data <=e)) {
            ans = optimizedCount(root.left, s, e) + optimizedCount(root.right, s, e) + 1;
        }

        if(root.data < s) {
            ans = optimizedCount(root.right, s, e);
        }

        if(root.data > e) {
            ans = optimizedCount(root.left, s, e);
        }

        return ans;
    }

    // brute force
    private static int count(TreeNode root, int s, int e) {

        if(root == null) {
            return 0;
        }

        int count = 0;
        if((root.data >= s) && (root.data <=e)) {
            count++;
        }

        return count + count(root.left, s, e) + count(root.right, s, e);
    }

    public static TreeNode setup() {
        TreeNode root = new TreeNode(20);

        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode eighteen = new TreeNode(18);

        TreeNode thirty = new TreeNode(30);

        TreeNode fifty = new TreeNode(50);

        TreeNode forty = new TreeNode(40);
        TreeNode seventy = new TreeNode(70);


        root.left = ten;
        root.right = thirty;

        ten.left = five;
        ten.right = eighteen;

        thirty.right = fifty;

        fifty.left = forty;
        fifty.right = seventy;

        return root;
    }
}
