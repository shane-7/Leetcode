package 宫水三叶.树的搜索;

import java.util.ArrayList;
import java.util.List;

/** 二叉树的坡度
 * @author shkstart
 * @create 2022-04-18 11:51
 */
public class Easy2_563 {
    int res = 0;
    public int findTilt(TreeNode root) {
        postOrder(root);
        return res;
    }

    public int postOrder(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }
}
