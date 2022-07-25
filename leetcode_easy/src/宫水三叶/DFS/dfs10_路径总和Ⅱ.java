package 宫水三叶.DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-05-01 10:10
 */
public class dfs10_路径总和Ⅱ {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return res;
    }

    void dfs(TreeNode root, int targetSum, int sum) {
        if(root == null) return;
        sum += root.val;
        path.addLast(root.val);
        if (sum == targetSum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
            return;
        }

        if(root.left != null){
            dfs(root.left, targetSum, sum);
            path.removeLast();
        }
        if(root.right != null){
            dfs(root.right, targetSum, sum);
            path.removeLast();
        }
    }
}
