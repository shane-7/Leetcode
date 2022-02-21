package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**  104.二叉树的最大深度
 * @author shkstart
 * @create 2021-10-27 8:58
 */
public class BT8_104 {

    //1.递归法
    public int getdepth(TreeNode node){
        if(node == null) return 0;
        int leftdepth = getdepth(node.left);
        int rightdepth = getdepth(node.right);
        int depth = 1 + Math.max(leftdepth, rightdepth);
        return depth;
    }

    public int maxdepth(TreeNode root){
        return getdepth(root);
    }

    //2.迭代法：层序遍历
    public int maxDepth1(TreeNode root){
        if(root == null) return 0;
        int depth = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()){
            depth++; //记录深度
            int len = deque.size();
            while(len > 0){
                TreeNode node = deque.pop();
                if(node.left != null) deque.offerLast(node.left);
                if(node.right != null) deque.offerLast(node.right);
                len--;
            }
        }
        return depth;
    }


}
