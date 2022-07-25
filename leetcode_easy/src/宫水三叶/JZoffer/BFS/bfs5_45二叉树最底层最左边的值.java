package 宫水三叶.JZoffer.BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-05-06 17:56
 */
public class bfs5_45二叉树最底层最左边的值 {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if(root.left == null && root.right == null) return root.val;
        deque.addLast(root);
        int ans = Integer.MIN_VALUE;
        while(!deque.isEmpty()){
            int sz = deque.size();
            for(int i = 0; i < sz; i++){
                TreeNode cur = deque.pollFirst();
                if(i == 0){
                    ans = cur.val;
                }
                if(cur.left != null) deque.addLast(cur.left);
                if(cur.right != null) deque.addLast(cur.right);

            }
        }
        return ans;
    }
}
