package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shkstart
 * @create 2021-10-31 15:36
 */
public class BT14_404 {
    //递归法
    public int sumOfleftLeaves(TreeNode root){
        if(root == null) return 0;
        int leftValue = sumOfleftLeaves(root.left);
        int rightValue = sumOfleftLeaves(root.right);
        int midValue = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            midValue = root.left.val;
        }
        int sum = midValue + leftValue + rightValue;
        return sum;
    }

    //迭代法：
    public int sumOfLeftLeaves1(TreeNode root){
        if(root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int res = 0;
        while(!deque.isEmpty()){
            TreeNode node = deque.pop();
            if(node.left != null && node.left.left == null && node.left.right == null){
                res = node.left.val;
            }
            if(node.right != null) deque.push(node.right);
            if(node.left != null) deque.push(node.left);

        }
        return res;
    }
}
