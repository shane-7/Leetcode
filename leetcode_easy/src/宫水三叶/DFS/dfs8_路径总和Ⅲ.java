package 宫水三叶.DFS;
import java.util.Deque;
import java.util.LinkedList;

/**  用两个dfs, dfs1用来遍历根节点的变化；dfs2遍历以dfs1中根节点的子节点，并判断是否有符合要求的路径。
 * @author shkstart
 * @create 2022-05-01 9:36
 */
public class dfs8_路径总和Ⅲ {
    int res = 0;
    int t = 0;
    Deque<Integer> path = new LinkedList<>();
    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        dfs1(root);
        return res;
    }

    void dfs1(TreeNode root){
        if(root == null) return;
        dfs2(root, t, 0);
        dfs1(root.left);
        dfs1(root.right);
    }

    void dfs2(TreeNode root, int t, int sum){
        if(root == null) return;
        sum += root.val;
        if(sum == t){
            res++;
        }

        if(root.left != null){
            dfs2(root.left, t, sum);
        }
        if(root.right != null){
            dfs2(root.right, t, sum);
        }

    }
}
