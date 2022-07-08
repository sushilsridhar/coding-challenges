package trees.adv2;
// TODO
public class OddEvenLevel {

    public int solve(TreeNode A) {
        TreeNode root = A;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int evenSum = 0;
        int oddSum = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;

            while(size > 0) {
                TreeNode node = queue.poll();

                if((level & 1) == 1)
                    oddSum = oddSum + node.val;
                else
                    evenSum = evenSum + node.val;

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);

                size--;
            }
        }

        return oddSum-evenSum;
    }
}
