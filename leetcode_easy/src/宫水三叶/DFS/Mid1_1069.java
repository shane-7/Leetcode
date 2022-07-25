package 宫水三叶.DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-04-19 10:16
 */
public class Mid1_1069 {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        boolean isEven = false;
        while(!deque.isEmpty()) {
            int size = deque.size();
            isEven = !isEven;
            int preNum = isEven ? 0 : 1000000;
            while (size-- > 0) {
                TreeNode node = deque.pollFirst();
                int cur = node.val;
                //是奇数层
                if(!isEven && (cur % 2 != 0 || cur >= preNum)) return false;
                //如果是偶数层
                if(isEven && (cur % 2 == 0 || cur <= preNum)) return false;
                preNum = cur;
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
             }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "dadsda";
        s.length();
        List<String> std = new ArrayList<>();
    }

}
