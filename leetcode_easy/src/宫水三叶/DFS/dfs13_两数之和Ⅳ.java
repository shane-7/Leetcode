package 宫水三叶.DFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**  653 二叉搜索树 找两树之和
 * @author shkstart
 * @create 2022-05-05 11:42
 */

public class dfs13_两数之和Ⅳ {
    boolean res = false;
    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> ld = new LinkedList<>(), rd = new LinkedList<>();
        TreeNode temp = root;
        while(temp != null){
            ld.addLast(temp);
            temp = temp.left;
        }
        temp = root;
        while(temp != null){
            rd.addLast(temp);
            temp = temp.right;
        }

        TreeNode l = ld.peekLast(), r = rd.peekLast();
        while(l.val < r.val){
            int t = l.val + r.val;
            if(t == k) return true;
            if(t < k) l = getNext(ld, true);
            else r = getNext(rd, false);
        }
        return false;
    }

    TreeNode getNext(Deque<TreeNode> d, boolean isLeft){
        TreeNode node = isLeft? d.pollLast().right : d.pollLast().left;
        while (node != null){
            d.addLast(node);
            node = isLeft? node.left : node.right;
        }
        return d.peekLast();
    }


}
