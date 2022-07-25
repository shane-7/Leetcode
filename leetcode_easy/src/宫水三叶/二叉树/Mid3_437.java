package 宫水三叶.二叉树;

/** 路径总和III
 *
 *  DFS
 *
 * @author shkstart
 * @create 2022-04-18 18:37
 */
public class Mid3_437 {
    int ans = 0;
    int target = 0;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        dfs1(root);
        return ans;

    }
    public void dfs1(TreeNode root){
        if(root == null) return;
        dfs2(root, target - root.val);
        dfs1(root.left);
        dfs1(root.right);
    }
    public void dfs2(TreeNode root, int val){
        if(val == 0) ans++;
        if(root.left != null) dfs2(root.left, val - root.left.val);
        if(root.right != null) dfs2(root.right, val - root.right.val);
    }
}
