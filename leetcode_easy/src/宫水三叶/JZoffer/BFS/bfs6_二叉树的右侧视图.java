package 宫水三叶.JZoffer.BFS;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-05-06 18:34
 */
//找到每层的最右侧节点
public class bfs6_二叉树的右侧视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null) return res;
        deque.addLast(root);
        while(!deque.isEmpty()){
            int sz = deque.size();
            for(int i = 0; i < sz; i++){
                TreeNode cur = deque.pollFirst();
                if(i == sz - 1 ){
                    res.add(cur.val);
                }
                if(cur.left != null) deque.addLast(cur.left);
                if(cur.right != null) deque.addLast(cur.right);
            }
        }
        return res;
    }
}
