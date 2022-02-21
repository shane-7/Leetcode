package Dynamic_Programming;

/** 337.打家劫舍Ⅲ, 非常值得多思考，多做！！！
 * @author shkstart
 * @create 2021-12-22 10:42
 */
public class DP31_337 {
    public int rob(TreeNode root){
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robTree(TreeNode cur){
        //终止条件
        if(cur == null) return new int[]{0, 0};
        //返回的数组长度为2，代表两个状态， 0 为不偷当前节点，1 为偷当前节点
        int[] left = robTree(cur.left);
        int[] right = robTree(cur.right);
        //偷当前节点
        int val1 = cur.val + left[0] + right[0];
        //不偷当前节点
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //返回两个状态
        return new int[]{val2, val1};
    }
}
