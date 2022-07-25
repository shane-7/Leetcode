package 宫水三叶.DP.beibao01;

/** 01背包，用一维数组
 * @author shkstart
 * @create 2022-05-26 9:44
 */
public class BeiBao2_最后一块石头的重量Ⅱ {
    public int lastStoneWeightII(int[] stones) {
        int sum  = 0;
        for(int i : stones){
            sum += i;
        }
        int target = sum / 2;

        //1.dp[j]数组以及下标j的含义：
        //表示容量为j的背包，最多可以背dp[j]重的石头
        //2.确定递推公式
        //dp[j] = max(dp[j], dp[j - stones[i]] + stones[i])
        //3.dp数组如何初始化
        int[] dp = new int[15000];
        //4.确定遍历顺序
        for(int i = 0; i < stones.length; i++){
            for(int j = target; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        //dp[target]里是容量为target的背包所能背的最大重量。

        //在计算target的时候，target = sum / 2 因为是向下取整，所以sum - dp[target] 一定是大于等于dp[target]的。
        return (sum - dp[target]) - dp[target];
    }
}
