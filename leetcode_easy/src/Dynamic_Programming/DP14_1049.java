package Dynamic_Programming;

/** 1049.最后一块石头的重量II
 * @author shkstart
 * @create 2021-12-07 19:59
 */
public class DP14_1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i : stones){
            sum += i;
        }
        //注意：因为target是向下取整，所以sum - target * 2 >= 0
        int target = sum / 2;

        //1.确定dp数组的下标以及含义：
        //dp[j]: 表示容量为j的背包，最多可以背dp[j]这么重的石头
        //本题物品的重量为store[i]，价值也为store[i]
        //2.确定递推公式
        //dp[j] = max(dp[j], dp[j - stones[i]] + stones[i]);
        //3.初始化：
        //最大容量是所有石头的重量和

        //dp初始化
        int[] dp = new int[15001];

        for(int i = 0; i < stones.length; i++){
            for(int j = target; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        //最后分成的两堆石头：
        //一堆是dp[target], 另一堆是 sum - dp[target]， 因为要使得dp[target]尽量等于target, 所以
        //dp[target] <= target，所以 (sum - dp[target]) - dp[target] 是大于等于 0

        return (sum - dp[target]) - dp[target];

    }
}
