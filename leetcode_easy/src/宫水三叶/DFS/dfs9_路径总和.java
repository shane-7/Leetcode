package 宫水三叶.DFS;

/**
 * @author shkstart
 * @create 2022-05-01 9:39
 */
public class dfs9_路径总和 {
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return res;
    }
    void dfs(TreeNode node, int targetSum, int sum){
        if(node == null) return;
        sum += node.val;
        if(sum == targetSum && node.left == null && node.right == null) {
            res = true;
            return;
        }

        if(node.left != null){
            dfs(node.left, targetSum, sum);
        }
        if(node.right != null){
            dfs(node.right, targetSum, sum);
        }
    }
}
