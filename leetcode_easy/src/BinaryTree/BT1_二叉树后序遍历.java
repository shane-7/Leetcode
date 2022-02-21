package BinaryTree;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-12-22 9:02
 */
public class BT1_二叉树后序遍历 {
    //递归法：
    public ArrayList<Integer> postOrderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    //迭代法：后序遍历顺序：左- 右- 中， 压入栈的顺序：中- 左 - 右， 出栈顺序：中- 右- 左， 最后翻转结果
    public List<Integer> postOrderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.pop();  //先弹出中节点
            res.add(node.val);
            if(node.left != null){
                deque.addLast(node.left); //压入左节点
            }
            if(node.right != null){
                deque.addLast(node.right); //压入右节点；
            }
        }

        //翻转结果
        Collections.reverse(res);
        return res;
    }
}
