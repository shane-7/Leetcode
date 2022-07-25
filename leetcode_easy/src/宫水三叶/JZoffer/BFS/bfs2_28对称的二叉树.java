package 宫水三叶.JZoffer.BFS;

import java.util.GregorianCalendar;

/**
 * @author shkstart
 * @create 2022-05-05 14:48
 */
public class bfs2_28对称的二叉树 {
    boolean res = true;
    public boolean isSymmetric(TreeNode root) {
        return root == null? true : dfs(root.left, root.right);
    }
    boolean dfs(TreeNode L, TreeNode R){
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return dfs(L.left, R.right) && dfs(L.right, R.left);
    }
}
