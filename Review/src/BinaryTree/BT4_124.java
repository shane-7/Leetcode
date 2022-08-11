package BinaryTree;

public class BT4_124 {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;

        oneSideMax(root);
        return res;
    }

    int oneSideMax(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMaxSum = Math.max(0, oneSideMax(root.left));
        int rightMaxSum = Math.max(0, oneSideMax(root.right));

        int pathSum = leftMaxSum + root.val + rightMaxSum;
        res = Math.max(res, pathSum);
        return Math.max(leftMaxSum, rightMaxSum) + root.val;
    }
}
