package 宫水三叶.JZoffer.BFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-05-05 17:42
 */
public class bfs4_44二叉树每层的最大值 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> path = new LinkedList<>();
        if(root == null) return res;
        path.addLast(root);
        while(!path.isEmpty()){
            int max = Integer.MIN_VALUE;
            int sz = path.size();
            for(int i = 0; i < sz; i++){
                TreeNode cur = path.poll();
                max = Math.max(cur.val, max);
                if(cur.left != null){
                    path.addLast(cur.left);
                }
                if(cur.right != null){
                    path.addLast(cur.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
