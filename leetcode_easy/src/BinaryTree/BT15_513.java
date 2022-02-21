package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;


/** 513.找树左下角的值
 * @author shkstart
 * @create 2021-10-31 19:19
 */
public class BT15_513 {
    //层序遍历法
    public int findBottomLeftValue(TreeNode root){
        if(root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        int res = 0;
        deque.addLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode node = deque.pollFirst();
                if(i == 0) res = node.val;  //把每一层的第一个值给出去，以作树左下角值的备用
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }
        }
        return res;
    }
}
