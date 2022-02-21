package BinaryTree;

/** 112.路径总和==目标值
 * @author shkstart
 * @create 2021-10-31 19:53
 */
public class BT16_112 {
    private boolean traversal(TreeNode cur, int count){
        if(cur.left == null && cur.right == null && count == 0){
            return true;
        }
        //遇到叶子节点，直接返回
        if(cur.left == null && cur.right == null){
            return false;
        }
        if(cur.left != null){
            count = count - cur.left.val;//递归，处理节点
            if(traversal(cur.left, count)) return true;
            count = count + cur.left.val;//回溯，撤销处理结果
        }
        if(cur.right != null){
            count = count - cur.right.val;//递归，处理节点
            if(traversal(cur.right, count)) return true;
            count = count + cur.right.val;//回溯，撤销处理结果
        }
        return false;

    }

    public boolean haspathsum(TreeNode root, int sum){
        if(root == null) return false;
        return traversal(root, sum - root.val);
    }

}
