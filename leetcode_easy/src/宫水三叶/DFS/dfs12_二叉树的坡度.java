package 宫水三叶.DFS;

/**
 * @author shkstart
 * @create 2022-05-01 15:25
 */
public class dfs12_二叉树的坡度 {
    int res = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }

    int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;

    }
}
