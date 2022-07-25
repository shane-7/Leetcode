package 宫水三叶.DP.beibao01;

/** 一维数组
 * @author shkstart
 * @create 2022-05-26 9:14
 */
public class BeiBao1_分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;

        //1.确定dp数组以及下标的含义
//        01背包中，dp[j] 表示： 容量为j的背包，所背的物品价值可以最大为dp[j]。
//        套到本题，dp[j]表示 背包总容量是j，最大可以凑成j的子集总和为dp[j]。
        //2.确定递推公式
//        01背包的递推公式为：dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
//        本题，相当于背包里放入数值，那么物品i的重量是nums[i]，其价值也是nums[i]。
//        所以递推公式：dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);
        //3.dp数组如何初始化
//        如果题目给的价值都是正整数那么非0下标都初始化为0就可以了，如果题目给的价值有负数，那么非0下标就要初始化为负无穷。
        int[] dp = new int[10001];

        //4.确定遍历顺序
//        如果使用一维dp数组，物品遍历的for循环放在外层，遍历背包的for循环放在内层，且内层for循环倒序遍历！

        //开始01背包
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){  // 每一个元素一定是不可重复放入，所以从大到小遍历
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }

    public static void main(String[] args) {
        BeiBao1_分割等和子集 test = new BeiBao1_分割等和子集();
        boolean res = test.canPartition(new int[]{1, 5, 11, 5});
        System.out.println(res);

    }
}
