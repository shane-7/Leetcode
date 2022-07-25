package 宫水三叶.二叉树;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-04-18 17:42
 */
public class Mid1_230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        while(cur != null || !deque.isEmpty()){
            if(cur != null){
                deque.addLast(cur);
                cur = cur.left;
            }else{
                cur = deque.pollLast();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res.get(k - 1);

    }
}
