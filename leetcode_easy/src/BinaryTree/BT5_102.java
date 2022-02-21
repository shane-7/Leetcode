package BinaryTree;

import java.util.*;

/** 层序遍历
 *  可作为二叉树层序遍历的模板
 * @author shkstart
 * @create 2021-10-25 16:25
 */
public class BT5_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();

        if(root == null) return null;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()){
            List<Integer> res = new ArrayList<Integer>();
            int len = deque.size();

            while(len > 0){
                TreeNode tempNode = deque.pollFirst();
                res.add(tempNode.val);

                if(tempNode.left != null) deque.offerLast(tempNode.left);
                if(tempNode.right != null) deque.offerLast(tempNode.right);
                len--;
            }
            resList.add(res);
        }
        return resList;
    }

//    public List<List<Integer>> chechFun02(TreeNode node, List<List<Integer>> resList){
//        if(node == null) return null;
//        Queue<TreeNode> que = new LinkedList<>();
//        que.offer(node);
//
//        while(!que.isEmpty()){
//            List<Integer> res = new ArrayList<Integer>();
//            int len = que.size();
//
//            while(len > 0){
//                TreeNode tempNode = que.poll();
//                res.add(tempNode.val);
//
//                if(tempNode.left != null) que.offer(tempNode.left);
//                if(tempNode.right != null) que.offer(tempNode.right);
//                len--;
//            }
//            resList.add(res);
//        }
//        return resList;
//    }
}


