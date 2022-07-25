package 宫水三叶.DP;


import java.util.HashMap;
import java.util.Map;

public class DP5_打家劫舍Ⅲ {

    /**
     * 递归暴力解法, 单次递归分3类：1.偷父节点，2.偷左子节点，3.偷右子节点
     * @param root
     * @return
     */
    public int rob1(TreeNode root){
        //1.考虑边界条件
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        //偷父节点
        int money = root.val;
        if(root.left != null){
            money += rob1(root.left.left) + rob1(root.left.right);
        }
        if(root.right != null){
            money += rob1(root.right.left) + rob1(root.right.right);
        }
        return Math.max(money, rob1(root.left) + rob1(root.right));
    }

    // 2.递归去偷，记录状态
    // 执行用时：3 ms , 在所有 Java 提交中击败了 56.24% 的用户
    public int rob2(TreeNode root){
        Map<TreeNode, Integer> memo = new HashMap<>();
        int result = robAction(root, memo);
        return result;
    }
    int robAction(TreeNode root, Map<TreeNode, Integer> memo){
        if(root == null) return 0;
        if(memo.containsKey(root)) return memo.get(root);
        //偷父节点
        int money = root.val;
        if(root.left != null){
            money += robAction(root.left.left, memo) + robAction(root.left.right, memo);
        }
        if(root.right != null){
            money += robAction(root.right.left, memo) + robAction(root.right.right, memo);
        }
        int res = Math.max(money, robAction(root.left, memo) + robAction(root.right, memo));
        memo.put(root, res);
        return res;
    }

    //3.状态标记递归 DP
    // 执行用时：0 ms , 在所有 Java 提交中击败了 100% 的用户
    // 不偷：Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
    // root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) +
    // Math.max(rob(root.right)[0], rob(root.right)[1])
    // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
    // root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
    public int rob3(TreeNode root){
        int[] result = robAction1(root);
        return Math.max(result[0], result[1]);
    }

    int[] robAction1(TreeNode root){
        int[] res = new int[2];
        if(root == null) return res;
        //当前节点不偷,分析偷不偷左右孩子
        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);
        //
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

}
