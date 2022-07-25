package 宫水三叶.JZoffer.BFS;

import java.util.*;

/**
 * @author shkstart
 * @create 2022-05-05 17:00
 */
public class bfs3_32从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            res.add(node.val);
            if(node.left != null) {
                deque.addLast(node.left);
            }
            if(node.right != null){
                deque.addLast(node.right);
            }
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
